package com.github.furutuki.androidsvgtranscoder.transcoder

import java.io.PrintWriter
import java.io.StringWriter

/**
 * Base class of transcoder for svg element and attributes
 *
 * @author furutuki
 * created on 2022/12/01
 */
abstract class Transcoder<T> {

    abstract fun transcode(instance: T, output: PrintWriter)

    open fun transcode(instance: T): String {
        val out = StringWriter()
        transcode(instance, PrintWriter(out, true))
        return out.toString()
    }
}