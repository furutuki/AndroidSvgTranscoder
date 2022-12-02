package com.github.furutuki.androidsvgtranscoder.transcoder.stroke

import com.github.furutuki.androidsvgtranscoder.transcoder.Transcoder
import java.awt.BasicStroke
import java.io.PrintWriter

/**
 * Transcode line join attribute for stroke
 *
 * @author furutuki
 * created on 2022/12/01
 */
object StrokeLineJoinTransCoder: Transcoder<BasicStroke>() {

    override fun transcode(instance: BasicStroke, output: PrintWriter) {
        when (instance.lineJoin) {
            BasicStroke.JOIN_MITER -> output.append("strokePaint.setStrokeJoin(Paint.Join.MITER);")
            BasicStroke.JOIN_ROUND -> output.append("strokePaint.setStrokeJoin(Paint.Join.ROUND);")
            BasicStroke.JOIN_BEVEL -> output.append("strokePaint.setStrokeJoin(Paint.Join.BEVEL);")
        }
    }
}