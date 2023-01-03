package com.github.furutuki.androidsvgtranscoder.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Svg transcoder plugin
 *
 * @author furutuki
 * created on 2023/01/03
 */
class SvgTranscoderPlugin: Plugin<Project> {

    override fun apply(project: Project) {
        project.extensions.create("svgTranscoder", SvgConverterExtension::class.java)
        project.tasks.create("svgBatchConverter", SvgBatchConverterTask::class.java) {
            it.doLast {
                println("Svg transcoding completed")
            }
        }
    }
}