package com.github.furutuki.androidsvgtranscoder.transcoder.shape

import com.github.furutuki.androidsvgtranscoder.transcoder.Transcoder
import java.awt.geom.PathIterator
import java.io.PrintWriter

/**
 * Transcoder for 'path'
 *
 * @author furutuki
 * created on 2022/12/01
 */
object PathTranscoder: Transcoder<PathIterator>() {

    override fun transcode(instance: PathIterator, output: PrintWriter) {
        val coords = FloatArray(6)
        output.println("path.reset();")
        while (!instance.isDone) {
            when (instance.currentSegment(coords)) {
                PathIterator.SEG_CUBICTO -> output.println("path.cubicTo(${coords[0]}f, ${coords[1]}f, ${coords[2]}f, ${coords[3]}f, ${coords[4]}f, ${coords[5]}f);")
                PathIterator.SEG_QUADTO -> output.println("path.quadTo(${coords[0]}f, ${coords[1]}f, ${coords[2]}f, ${coords[3]}f);")
                PathIterator.SEG_MOVETO -> output.println("path.moveTo(${coords[0]}f, ${coords[1]}f);")
                PathIterator.SEG_LINETO -> output.println("path.lineTo(${coords[0]}f, ${coords[1]}f);")
                PathIterator.SEG_CLOSE -> output.println("path.close();")
            }
            instance.next()
        }
    }
}