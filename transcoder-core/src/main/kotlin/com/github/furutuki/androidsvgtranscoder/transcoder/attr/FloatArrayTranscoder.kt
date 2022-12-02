package com.github.furutuki.androidsvgtranscoder.transcoder.attr

import com.github.furutuki.androidsvgtranscoder.transcoder.Transcoder
import java.io.PrintWriter


/**
 *
 * transcoder for float array
 *
 * @author furutuki
 * created on 2022/12/01
 */
object FloatArrayTranscoder: Transcoder<FloatArray>() {

    override fun transcode(instance: FloatArray, output: PrintWriter) {
        var comma = ""
        output.append("new float[]{")
        for (value in instance) {
            output.append(comma)
            output.append(FloatTranscoder.transcode(value))
            comma = ", "
        }
        output.append("}")
    }
}