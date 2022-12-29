package com.github.furutuki.androidsvgtranscoder

import com.github.furutuki.androidsvgtranscoder.transcoder.attr.TransformTranscoder
import com.github.furutuki.androidsvgtranscoder.transcoder.attr.FloatTranscoder
import com.github.furutuki.androidsvgtranscoder.transcoder.shape.ShapeTranscoder
import com.github.furutuki.androidsvgtranscoder.transcoder.stroke.*
import org.apache.batik.bridge.*
import org.apache.batik.gvt.*
import org.w3c.dom.Document
import org.xml.sax.EntityResolver
import org.xml.sax.InputSource
import org.xml.sax.XMLReader
import java.awt.*
import java.awt.geom.Rectangle2D
import java.io.*
import java.net.URL
import java.util.*
import java.util.logging.Level
import java.util.logging.Logger
import java.util.zip.GZIPInputStream
import javax.xml.parsers.SAXParser
import javax.xml.parsers.SAXParserFactory
import javax.xml.transform.Transformer
import javax.xml.transform.TransformerFactory
import javax.xml.transform.sax.SAXSource
import javax.xml.transform.stream.StreamResult
import javax.xml.transform.stream.StreamSource
import kotlin.math.ceil

/**
 * A svg transcoder
 *
 * @author furutuki
 * created on 2022/12/01
 */
class SvgTranscoder constructor(var javaClassName: String?) {

    /** The output writer receiving the generated class.  */
    var externalPrintWriter: PrintWriter? = null

    /** Temporary buffer holding the code being generated.  */
    private lateinit var printWriter: PrintWriter

    /** Package name for the generated java code.  */
    var javaPackageName: String? = null

    /** The template of the generated classes  */
    private var template: Template = Template.getDefault()

    /** URL of the SVG file.  */
    private var url: URL? = null

    /** The current composite.  */
    private var currentComposite: AlphaComposite? = null

    /** The current shape.  */
    private var currentShape: Shape? = null

    constructor(url: URL?, javaClassname: String?): this(javaClassname) {
        this.url = url
    }

    /**
     * Returns the filtered image content. The metadata are removed from
     * the document to prevent illegal elements from breaking the parsing.
     * (For example several KDE icons have unrecognized RDF elements)
     */
    @Throws(Exception::class)
    private fun getInputStream(url: URL): InputStream? {
        val buffer = ByteArrayOutputStream()
        val factory: SAXParserFactory = SAXParserFactory.newInstance()
        factory.isNamespaceAware = true

        val parser: SAXParser = factory.newSAXParser()
        val reader: XMLReader = parser.xmlReader
        reader.entityResolver = EntityResolver { _, _ -> InputSource(StringReader("")) }

        val input: InputSource = if (url.toString().endsWith(".svgz")) {
            InputSource(GZIPInputStream(url.openStream()))
        } else {
            InputSource(url.openStream())
        }

        val source = SAXSource(reader, input)
        val result = StreamResult(buffer)
        val stylesheet = StreamSource(javaClass.getResourceAsStream("/svg-cleanup.xsl"))
        val transformer: Transformer = TransformerFactory.newInstance().newTransformer(stylesheet)
        transformer.transform(source, result)
        stylesheet.inputStream.close()

        return ByteArrayInputStream(buffer.toByteArray())
    }

    /**
     * Transcodes a SVG file into android source code.
     */
    fun transcode() {
        if (externalPrintWriter == null) {
            return
        }
        val ua = UserAgentAdapter()
        val loader = DocumentLoader(ua)
        val context = BridgeContext(ua, loader)
        context.setDynamicState(BridgeContext.DYNAMIC)
        ua.setBridgeContext(context)
        try {
            url?.also { url ->
                val svgDoc: Document = loader.loadDocument(url.toString(), getInputStream(url))
                GVTBuilder().build(context, svgDoc)
                transcode(context)
            }
        } catch (e: Exception) {
            Logger.getLogger(javaClass.name).log(Level.SEVERE, "Unable to transcode $url", e)
        }
    }

    fun setTemplate(template: Template) {
        this.template = template
    }

    /**
     * Transcode a SVG file into android source code.
     */
    @Throws(IOException::class)
    fun transcode(context: BridgeContext) {
        val root = context.getGraphicsNode(context.document)
        val paintingCodeStream = ByteArrayOutputStream()
        printWriter = IndentingPrintWriter(PrintWriter(paintingCodeStream))
        transcodeGraphicsNode(root, "")
        printWriter.close()
        val separator = ("        paint\${count}(g, origAlpha, transformations);\n"
                + "    }\n\n"
                + "    private static void paint\${count}(Graphics2D g, float origAlpha, java.util.LinkedList<AffineTransform> transformations) {\n"
                + "        Shape shape = null;\n")
        var paintingCode: String = String(paintingCodeStream.toByteArray())
        paintingCode = TextSplitter.insert(paintingCode, separator, 3000)
        var bounds = root.bounds
        if (bounds == null) {
            bounds = Rectangle2D.Double(0.0, 0.0, context.documentSize.width, context.documentSize.height)
        }
        val params: MutableMap<Template.Token, Any?> = HashMap()
        params[Template.Token.PACKAGE] = if (javaPackageName != null) "package $javaPackageName;" else ""
        params[Template.Token.CLASSNAME] = javaClassName
        params[Template.Token.X] = ceil(bounds.x).toInt()
        params[Template.Token.Y] = ceil(bounds.y).toInt()
        params[Template.Token.WIDTH] = ceil(bounds.width).toInt()
        params[Template.Token.HEIGHT] = ceil(bounds.height).toInt()
        params[Template.Token.PAINTING_CODE] = paintingCode
        template.apply(externalPrintWriter, params)
    }

    /**
     * Transcodes the specified shape.
     *
     * @param shape Shape.
     * @throws UnsupportedOperationException if the shape is unsupported.
     */
    @Throws(UnsupportedOperationException::class)
    private fun transcodeShape(shape: Shape) {
        if (shape === currentShape) {
            return
        }
        ShapeTranscoder.transcode(shape, printWriter)
        applyTransform()
        currentShape = shape
    }

    /**
     * Transcodes the specified shape painter.
     *
     * @param painter Shape painter.
     * @throws UnsupportedOperationException if the shape painter is unsupported.
     */
    @Throws(UnsupportedOperationException::class)
    private fun transcodeShapePainter(painter: ShapePainter?) {
        if (painter is CompositeShapePainter) {
            transcodeCompositeShapePainter(painter)
        } else if (painter is FillShapePainter) {
            transcodeFillShapePainter(painter)
        } else if (painter is StrokeShapePainter) {
            transcodeStrokeShapePainter(painter)
        } else if (painter != null) {
            throw UnsupportedOperationException(painter.javaClass.canonicalName)
        }
    }

    /**
     * Transcode the specified composite shape painter.
     *
     * @param painter Composite shape painter.
     */
    private fun transcodeCompositeShapePainter(painter: CompositeShapePainter) {
        for (i in 0 until painter.shapePainterCount) {
            transcodeShapePainter(painter.getShapePainter(i))
        }
    }

    private fun applyTransform() {
        printWriter.println("applyTransform(matrixList);")
        printWriter.println("path.transform(matrix);")
    }

    /**
     * Transcode the specified fill shape painter.
     *
     * @param painter Fill shape painter.
     */
    private fun transcodeFillShapePainter(painter: FillShapePainter) {
        val paint: Paint = painter.paint ?: return
        transcodeShape(painter.shape)
        transcodePaintChange(paint, true)
        printWriter.println("canvas.drawPath(path, paint);")
        printWriter.println()
    }

    private fun transcodePaintChange(paint: Paint, fill: Boolean) {
        if (paint is Color) {
            val color: Color = paint
            printWriter.println(
                (if (fill) "paint" else "strokePaint") + ".setColor(Color.argb("
                        + getPaintAlphaString(color.alpha) + ", "
                        + color.red + ", " + color.green + ", " + color.blue + "));"
            )
        }
    }

    private fun getPaintAlphaString(alpha: Int): String {
        return if (currentComposite != null && currentComposite!!.alpha != 1f) {
            "(int)(${currentComposite!!.alpha} * $alpha)"
        } else {
            "$alpha"
        }
    }

    /**
     * Transcode the specified stroke shape painter.
     *
     * @param painter Stroke shape painter.
     */
    private fun transcodeStrokeShapePainter(painter: StrokeShapePainter) {
        val paint: Paint = painter.paint ?: return
        transcodeShape(painter.shape)
        transcodePaintChange(paint, false)
        transcodeStrokeChange(painter.stroke)
        printWriter.println("canvas.drawPath(path, strokePaint);")
        printWriter.println()
    }

    private fun transcodeStrokeChange(stroke: Stroke) {
        val stk = stroke as BasicStroke
        printWriter.println(StrokeLineWidthTransCoder.transcode(stk))
        printWriter.println(StrokeEndCapTransCoder.transcode(stk))
        printWriter.println(StrokeLineJoinTransCoder.transcode(stk))
        printWriter.println(StrokeMiterLimitTransCoder.transcode(stk))
        printWriter.println(StrokeDashEffectTranscoder.transcode(stk))
    }

    /**
     * Transcode alphaComposite to PorterDuff.Mode
     */
    private fun transcodeCompositeChange(composite: AlphaComposite?) {
        if ((composite != null) && composite != currentComposite && !(currentComposite == null && composite.alpha == 1f)) {
            currentComposite = composite
        }
    }

    /**
     * Transcode the specified graphics node.
     *
     * @param node    Graphics node.
     * @param comment Comment (for associating the Android source section with the corresponding SVG section).
     * @throws UnsupportedOperationException if the graphics node is unsupported.
     */
    @Throws(UnsupportedOperationException::class)
    private fun transcodeGraphicsNode(node: GraphicsNode, comment: String) {
        transcodeCompositeChange(getAbsoluteAlphaComposite(node))
        val transform = node.transform
        if (transform != null && !transform.isIdentity) {
            val matrix = TransformTranscoder.transcode(transform)
            printWriter.println(matrix)
            printWriter.println("matrixList.push(transform);")
        }
        try {
            printWriter.println("")
            printWriter.println("// $comment")
            if (node is ShapeNode) {
                transcodeShapePainter(node.shapePainter)
            } else if (node is CompositeGraphicsNode) {
                val children = node.children
                for (i in children.indices) {
                    transcodeGraphicsNode(children[i] as GraphicsNode, comment + "_" + i)
                }
            } else if (node is TextNode) {
                transcodeTextNode(node)
            } else {
                throw UnsupportedOperationException(node.javaClass.canonicalName)
            }
        } finally {
            if (transform != null && !transform.isIdentity) {
                printWriter.println()
                printWriter.println("matrixList.pop();")
            }
        }
    }

    /**
     * Get the absolute alpha composite of a node.
     */
    private fun getAbsoluteAlphaComposite(node: GraphicsNode): AlphaComposite? {
        var composite: AlphaComposite? = node.composite as? AlphaComposite
        if (composite != null) {
            var alpha = composite.alpha
            var curNode = node;
            while (curNode.parent != null) {
                curNode = curNode.parent
                val parentComposite: AlphaComposite? = curNode.composite as? AlphaComposite
                if (parentComposite != null) {
                    alpha *= parentComposite.alpha
                }
            }
            composite = AlphaComposite.getInstance(composite.rule, alpha)
        }
        return composite
    }

    /**
     * Transcode the specified text node.
     *
     * @param text
     */
    private fun transcodeTextNode(text: TextNode) {
        if (text.text == null) {
            return
        }
        printWriter.println("// " + text.text.replace("[\\r\\n]]".toRegex(), " "))
        val g: Graphics2D = object : NoOpGraphics2D() {
            override fun draw(shape: Shape) {
                transcodeShape(shape)
                printWriter.println("canvas.drawPath(path, paint);")
            }

            override fun fill(shape: Shape) {
                transcodeShape(shape)
                printWriter.println("canvas.drawPath(path, paint);")
            }

            override fun setComposite(comp: Composite) {
                transcodeCompositeChange(comp as AlphaComposite?)
            }

            override fun setPaint(paint: Paint) {
                transcodePaintChange(paint, true)
            }

            override fun setStroke(s: Stroke) {
                transcodeStrokeChange(s)
            }

            override fun getRenderingHint(hintKey: RenderingHints.Key): Any {
                return if ((hintKey == RenderingHints.KEY_TEXT_ANTIALIASING)) {
                    RenderingHints.VALUE_TEXT_ANTIALIAS_ON
                } else if ((hintKey == RenderingHints.KEY_STROKE_CONTROL)) {
                    RenderingHints.VALUE_STROKE_PURE
                } else {
                    throw UnsupportedOperationException("Unhandled hint: $hintKey")
                }
            }
        }
        text.textPainter.paint(text, g)
    }
}