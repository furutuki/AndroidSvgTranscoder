package com.github.furutuki.androidsvgtranscoder.sample

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import com.github.furutuki.androidsvgtranscoder.sample.svgobj.*

/**
 *
 * @author furutuki
 * created on 2022/12/02
 */
class SvgCanvasView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : View(context, attrs) {

    private val arrowDown = ArrowDown()
    private val line = Line()
    private val rect = Rectangle()
    private val circle = Circle()
    private val ellipse = Ellipse()
    private val pathCanvas = PathCanvas()
    private val polyline = Polyline()
    private val polyline2 = Polyline2()
    private val polygon = Polygon()
    private val textCanvas = Text()
    private val matrixCanvas = MatrixCanvas()
    private val close = Close()

    init {
        initView(context)
    }

    private fun initView(context: Context) {

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        close.paint(canvas, 24, 24, 620, 30)
        arrowDown.paint(canvas, 100, 80, 300, 10)
        line.paint(canvas, 100, 100, 10, 10);
        rect.paint(canvas, 300, 100, 10, 120)
        circle.paint(canvas, 300, 300, 90, 240)
        ellipse.paint(canvas, 300, 200, 480, 240)
        pathCanvas.paint(canvas, 500, 400, 240, 500)
        polyline.paint(canvas, 400, 400, 10, 900)
        polyline2.paint(canvas, 400, 400, 600, 900)
        polygon.paint(canvas, 92, 201, 10, 1320)
        textCanvas.paint(canvas, 200, 60, 10, 1600)
        matrixCanvas.paint(canvas, 330, 360, 600, 1600)
    }
}