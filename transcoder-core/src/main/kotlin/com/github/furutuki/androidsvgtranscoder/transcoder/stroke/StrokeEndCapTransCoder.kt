package com.github.furutuki.androidsvgtranscoder.transcoder.stroke

import com.github.furutuki.androidsvgtranscoder.transcoder.Transcoder
import java.awt.BasicStroke
import java.io.PrintWriter

/**
 * Transcode end cap attribute for stroke
 * @author furutuki
 * created on 2022/12/01
 */
object StrokeEndCapTransCoder: Transcoder<BasicStroke>() {

    override fun transcode(instance: BasicStroke, output: PrintWriter) {
        when (instance.endCap) {
            BasicStroke.CAP_BUTT -> output.append("strokePaint.setStrokeCap(Paint.Cap.BUTT);")
            BasicStroke.CAP_ROUND -> output.append("strokePaint.setStrokeCap(Paint.Cap.ROUND);")
            BasicStroke.CAP_SQUARE -> output.append("strokePaint.setStrokeCap(Paint.Cap.SQUARE);")
        }
    }
}