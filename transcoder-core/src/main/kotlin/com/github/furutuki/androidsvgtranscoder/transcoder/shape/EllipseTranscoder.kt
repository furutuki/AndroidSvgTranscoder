package com.github.furutuki.androidsvgtranscoder.transcoder.shape

import com.github.furutuki.androidsvgtranscoder.transcoder.Transcoder
import java.awt.geom.Ellipse2D
import java.io.PrintWriter

/**
 * Transcoder for circle and ellipse
 *
 * @author furutuki
 * created on 2022/12/01
 */
object EllipseTranscoder: Transcoder<Ellipse2D>() {

    override fun transcode(instance: Ellipse2D, output: PrintWriter) {
        output.println("path.reset();");
        output.println("path.addOval("
                + "${instance.x}f, "
                + "${instance.y}f, "
                + "${instance.x + instance.width}f, "
                + "${instance.y + instance.height}f, "
                + "Path.Direction.CW);");
    }
}