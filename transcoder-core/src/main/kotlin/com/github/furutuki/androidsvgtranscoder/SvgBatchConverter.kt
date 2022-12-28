package com.github.furutuki.androidsvgtranscoder

import java.io.File
import java.io.PrintWriter
import kotlin.system.exitProcess

/**
 * Tools that can batch convert svg files into android source code files
 *
 * @author furutuki
 * created on 2022/12/01
 **/

/**
 * @param args First parameter should point to a folder with SVG images, and
 * the second parameter should be the package name for the
 * transcoded classes.
 */
fun main(args: Array<String>) {
    if (args.size != 3) {
        println("param 0 : svg-file-dir,param 1: java-file-dir param 2: java-file-package-name")
        exitProcess(1)
    }
    val dir = File(args[0])
    if (!dir.exists()) {
        return
    }
    val outputBaseDir = File(args[1])
    if (!outputBaseDir.exists()) {
        outputBaseDir.mkdirs()
    }
    val namingStrategy: NamingStrategy = CamelCaseNamingStrategy()
    dir.listFiles { _, name -> name.endsWith(".svg") || name.endsWith(".svgz") }?.run {
        for (file in this) {
            val svgClassName: String = namingStrategy.getClassName(file)
            val javaClassFilename: String = outputBaseDir.toString() + File.separator.toString() + svgClassName + ".java"
            println("Processing " + file.name)
            try {
                val pw = PrintWriter(javaClassFilename)
                val transcoder = SvgTranscoder(file.toURI().toURL(), svgClassName)
                transcoder.javaPackageName = args[2]
                transcoder.externalPrintWriter = pw
                transcoder.transcode()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}