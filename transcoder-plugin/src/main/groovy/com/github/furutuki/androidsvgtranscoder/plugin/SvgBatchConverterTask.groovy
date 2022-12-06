package com.github.furutuki.androidsvgtranscoder.plugin

import com.github.furutuki.androidsvgtranscoder.SvgBatchConverterKt
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

class SvgBatchConverterTask extends DefaultTask {

    @Input
    String svgFolder

    @Input
    String packageName

    SvgBatchConverterTask() {

    }

    @TaskAction
    void transcode() {
        SvgBatchConverterKt.main(getSvgFolder(), getSrcOutputFolder())
    }
}