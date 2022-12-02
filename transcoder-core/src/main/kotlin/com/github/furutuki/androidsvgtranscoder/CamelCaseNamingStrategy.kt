package com.github.furutuki.androidsvgtranscoder

import java.io.File
import java.util.*

/**
 *
 * @author furutuki
 * created on 2022/12/01
 */
class CamelCaseNamingStrategy: NamingStrategy {

    override fun getClassName(file: File): String {
        val name: String = file.name.substring(0, file.name.lastIndexOf("."))
        val parts = name.split("(_|\\s|-)+".toRegex()).toTypedArray()
        val builder = StringBuilder()
        for (part in parts) {
            builder.append(part.substring(0, 1).uppercase(Locale.getDefault()))
            builder.append(part.substring(1))
        }
        return builder.toString()
    }
}