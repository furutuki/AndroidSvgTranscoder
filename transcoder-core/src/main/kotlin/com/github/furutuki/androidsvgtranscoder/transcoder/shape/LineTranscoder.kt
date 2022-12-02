package com.github.furutuki.androidsvgtranscoder.transcoder.shape

import com.github.furutuki.androidsvgtranscoder.transcoder.Transcoder
import java.awt.geom.Line2D
import java.io.PrintWriter

/**
 * Transcoder for 'line'
 *
 * @author furutuki
 * created on 2022/12/01
 */
object LineTranscoder: Transcoder<Line2D.Float>() {

    override fun transcode(instance: Line2D.Float, output: PrintWriter) {
        output.println("path.reset();")
        output.println(String.format("path.moveTo(%ff, %ff);", instance.x1, instance.y1))
        output.println(String.format("path.lineTo(%ff, %ff);", instance.x2, instance.y2))
    }
}