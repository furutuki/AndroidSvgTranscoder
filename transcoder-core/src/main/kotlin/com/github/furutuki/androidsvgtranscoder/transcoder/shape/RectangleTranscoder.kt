package com.github.furutuki.androidsvgtranscoder.transcoder.shape

import com.github.furutuki.androidsvgtranscoder.transcoder.Transcoder
import java.awt.geom.Rectangle2D
import java.io.PrintWriter

/**
 * Transcoder for rectangle
 *
 * @author furutuki
 * created on 2022/12/01
 */
object RectangleTranscoder: Transcoder<Rectangle2D>() {

    override fun transcode(instance: Rectangle2D, output: PrintWriter) {
        output.println("path.reset();");
        output.println("path.addRect("
                + "${instance.x}f, ${instance.y}f, "
                + "${instance.x + instance.width}f, "
                + "${instance.y + instance.height}f, "
                + "Path.Direction.CW);");
    }
}