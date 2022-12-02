package com.github.furutuki.androidsvgtranscoder.transcoder.attr

import com.github.furutuki.androidsvgtranscoder.transcoder.Transcoder
import java.io.PrintWriter
import kotlin.math.abs
import kotlin.math.roundToInt
import kotlin.math.roundToLong

/**
 * Transcoder for double value
 *
 * @author furutuki
 * created on 2022/12/01
 */
object DoubleTranscoder: Transcoder<Double>() {

    override fun transcode(instance: Double, output: PrintWriter) {
        if (abs(instance.roundToLong() - instance) < 0.000001) {
            output.append(instance.roundToInt().toString())
        } else {
            output.append(instance.toString())
        }
    }
}