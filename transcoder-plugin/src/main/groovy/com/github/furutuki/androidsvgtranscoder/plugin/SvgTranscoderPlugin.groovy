package com.github.furutuki.androidsvgtranscoder.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class SvgTranscoderPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.extensions.create("svgTranscoder", SvgConverterExtension)
        project.task('svgBatchConverter', type: SvgBatchConverterTask) {
            doLast {
                println 'Svg transcoding completed'
            }
        }
    }
}