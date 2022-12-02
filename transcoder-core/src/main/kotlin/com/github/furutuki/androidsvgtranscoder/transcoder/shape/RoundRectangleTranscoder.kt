package com.github.furutuki.androidsvgtranscoder.transcoder.shape

import com.github.furutuki.androidsvgtranscoder.transcoder.Transcoder
import java.awt.geom.RoundRectangle2D
import java.io.PrintWriter

/**
 * transcoder for round rectangle
 *
 * @author furutuki
 * created on 2022/12/01
 */
object RoundRectangleTranscoder: Transcoder<RoundRectangle2D>() {
    override fun transcode(instance: RoundRectangle2D, output: PrintWriter) {
        output.println("path.reset();");
        output.println("path.addRoundRect("
                + "${instance.x}f, ${instance.y}f, "
                + "${instance.x + instance.width}f, "
                + "${instance.y + instance.height}f, "
                + "${instance.arcWidth}f, "
                + "${instance.arcHeight}f, "
                + "Path.Direction.CW);");
    }
}