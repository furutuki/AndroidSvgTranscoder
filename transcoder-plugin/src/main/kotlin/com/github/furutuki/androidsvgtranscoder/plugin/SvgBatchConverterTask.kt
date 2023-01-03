package com.github.furutuki.androidsvgtranscoder.plugin

import com.github.furutuki.androidsvgtranscoder.SvgBatchConverter
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * SVG batch converter task
 *
 * @author furutuki
 * created on 2023/01/03
 */
open class SvgBatchConverterTask: DefaultTask() {

    init {
        group = "svg-transcoder"
        description = "Svg transcoder task that transcode svg file to android source file(Java)"
    }

    @TaskAction
    fun transcode() {
        project.extensions.findByType(SvgConverterExtension::class.java)?.apply {
            SvgBatchConverter.convert(arrayOf(svgFolder, javaFolder, packageName))
        }
    }

}