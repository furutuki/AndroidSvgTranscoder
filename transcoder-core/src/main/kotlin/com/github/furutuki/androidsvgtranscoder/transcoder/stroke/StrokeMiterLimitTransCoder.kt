package com.github.furutuki.androidsvgtranscoder.transcoder.stroke

import com.github.furutuki.androidsvgtranscoder.transcoder.Transcoder
import java.awt.BasicStroke
import java.io.PrintWriter

/**
 * Transcode miter limit attribute for stroke
 *
 * @author furutuki
 * created on 2022/12/01
 */
object StrokeMiterLimitTransCoder: Transcoder<BasicStroke>() {

    override fun transcode(instance: BasicStroke, output: PrintWriter) {
        output.append("strokePaint.setStrokeMiter(").append(instance.miterLimit.toString()).append("f);");
    }
}