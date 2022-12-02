package com.github.furutuki.androidsvgtranscoder.transcoder.attr

import com.github.furutuki.androidsvgtranscoder.transcoder.Transcoder
import java.io.PrintWriter
import kotlin.math.abs
import kotlin.math.roundToLong

/**
 * Transcoder for float value
 *
 * @author furutuki
 * created on 2022/12/01
 */
object FloatTranscoder: Transcoder<Float>() {

    override fun transcode(instance: Float, output: PrintWriter) {
        if (abs(instance.roundToLong() - instance) < 0.000001) {
            output.append(instance.roundToLong().toString())
        } else {
            output.append(instance.toString()+ "f")
        }
    }
}