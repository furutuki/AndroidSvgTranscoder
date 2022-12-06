package com.github.furutuki.androidsvgtranscoder.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class SvgTranscoderPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        def extension = project.extensions.create("svgTranscoder", SvgConverterExtension)
        def task = project.tasks.create("svgBatchConverter", SvgBatchConverterTask)

        task.svgFolder = extension.svgFolder
        task.packageName = extension.packageName

        project.task('transcode', type: SvgBatchConverterTask) {
            doLast {
                println 'Svg transcoding completed'
            }
        }
    }
}