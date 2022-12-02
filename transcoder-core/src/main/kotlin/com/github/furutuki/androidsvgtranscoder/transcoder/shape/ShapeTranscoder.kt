package com.github.furutuki.androidsvgtranscoder.transcoder.shape

import com.github.furutuki.androidsvgtranscoder.transcoder.Transcoder
import org.apache.batik.ext.awt.geom.ExtendedGeneralPath
import java.awt.Shape
import java.awt.geom.*
import java.io.PrintWriter

/**
 * Transcode shape
 *
 * @author furutuki
 * created on 2022/12/01
 */
object ShapeTranscoder: Transcoder<Shape>() {

    override fun transcode(instance: Shape, output: PrintWriter) {
        when (instance) {
            is GeneralPath,
            is ExtendedGeneralPath -> {
                val newInst = instance.getPathIterator(null)
                PathTranscoder.transcode(newInst, output)
            }
            is Rectangle2D -> {
                RectangleTranscoder.transcode(instance, output)
            }
            is RoundRectangle2D -> {
                RoundRectangleTranscoder.transcode(instance, output)
            }
            is Ellipse2D -> {
                EllipseTranscoder.transcode(instance, output)
            }
            is Line2D.Float -> {
                LineTranscoder.transcode(instance, output)
            }
            else -> {
                throw UnsupportedOperationException(instance.javaClass.canonicalName)
            }
        }
    }
}