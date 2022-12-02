package com.github.furutuki.androidsvgtranscoder

import java.io.PrintWriter

/**
 *
 * @author furutuki
 * created on 2022/12/01
 */
class IndentingPrintWriter(out: PrintWriter): PrintWriter(out) {

    companion object {
        private const val INDENTATION = "        "
    }

    override fun println(s: String) {
        super.println(INDENTATION + s)
    }
}