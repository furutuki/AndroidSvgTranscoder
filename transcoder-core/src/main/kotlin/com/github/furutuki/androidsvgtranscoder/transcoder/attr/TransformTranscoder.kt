package com.github.furutuki.androidsvgtranscoder.transcoder.attr

import com.github.furutuki.androidsvgtranscoder.transcoder.Transcoder
import java.awt.geom.AffineTransform
import java.io.PrintWriter


/**
 * transcoder for 'transform'
 *
 * @author furutuki
 * created on 2022/12/01
 */
object TransformTranscoder: Transcoder<AffineTransform>() {

    override fun transcode(instance: AffineTransform, output: PrintWriter) {
        output.println("transform = new Matrix();")
        if (!instance.isIdentity) {
            val matrix = DoubleArray(6)
            instance.getMatrix(matrix)
            output.append("\t\ttransform.setValues(new float[]{")
                .append(FloatTranscoder.transcode(matrix[0].toFloat())).append(", ")
                .append(FloatTranscoder.transcode(matrix[2].toFloat())).append(", ")
                .append(FloatTranscoder.transcode(matrix[4].toFloat())).append(", ")
                .append(FloatTranscoder.transcode(matrix[1].toFloat())).append(", ")
                .append(FloatTranscoder.transcode(matrix[3].toFloat())).append(", ")
                .append(FloatTranscoder.transcode(matrix[5].toFloat())).append(", ")
                .append("0, 0, 1});")
                .println()
        }
    }
}