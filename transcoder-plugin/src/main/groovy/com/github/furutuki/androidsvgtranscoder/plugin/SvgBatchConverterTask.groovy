package com.github.furutuki.androidsvgtranscoder.plugin

import com.github.furutuki.androidsvgtranscoder.SvgBatchConverterKt
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class SvgBatchConverterTask extends DefaultTask {

    SvgBatchConverterTask() {
        group = 'svg-transcoder'
        description = 'Svg transcoder that transcode svg file to android java file'
    }

    @TaskAction
    void transcode() {
        String svgFolder = project.extensions.svgTranscoder.svgFolder
        String javaFolder = project.extensions.svgTranscoder.javaFolder
        String packageName = project.extensions.svgTranscoder.packageName
        SvgBatchConverterKt.main(svgFolder, javaFolder, packageName)
    }
}