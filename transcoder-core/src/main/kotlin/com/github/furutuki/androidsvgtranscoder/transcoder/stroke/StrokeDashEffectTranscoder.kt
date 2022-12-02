package com.github.furutuki.androidsvgtranscoder.transcoder.stroke

import com.github.furutuki.androidsvgtranscoder.transcoder.Transcoder
import java.awt.BasicStroke
import java.io.PrintWriter

/**
 * Transcode dash effect attribute for stroke
 *
 * @author furutuki
 * created on 2022/12/01
 */
object StrokeDashEffectTranscoder: Transcoder<BasicStroke>() {

    override fun transcode(instance: BasicStroke, output: PrintWriter) {
        if (instance.dashArray != null) {
            output.append("strokePaint.setPathEffect(new DashPathEffect(new float[]{");
            for ( i in 0 until instance.dashArray.size) {
                if (i > 0) {
                    output.append(", ");
                }
                output.append(instance.dashArray[i].toString());
            }
            output.append("},").append(instance.dashPhase.toString()).append("));");
        } else {
            output.append("strokePaint.setPathEffect(null);");
        }
    }
}