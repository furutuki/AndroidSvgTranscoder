package com.github.furutuki.androidsvgtranscoder.sample.svgobj;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;

import java.util.LinkedList;

/**
 * This class is generated automatically by using SvgAndroidTranscoder.
 *
 * @author furutuki furutuki@foxmail.com
 */
public class Text {

    private final Paint  paint       = new Paint();
    private final Paint  strokePaint = new Paint();
    private final Path   path        = new Path();
    private final Matrix matrix      = new Matrix();
    private final Matrix scaleMatrix = new Matrix();
    private ColorFilter  colorFilter = null;

    /**
     * Draw the svg on the specified canvas.
     *
     * @param canvas canvas object.
     * @param w the width of svg you draw
     * @param h the height of svg you draw
     * @param dx the x-offset of svg's left top in the canvas
     * @param dy the y-offset of svg's left top in the canvas
     */
    public void paint(Canvas canvas, int w, int h, int dx, int dy) {
        float svgWidth = 59f;
        float svgHeight= 9f;

        resetPaint();

        float scale = Math.min(w / svgWidth, h / svgHeight);
        canvas.save();
        canvas.translate((w - scale * svgWidth) / 2f + dx, (h - scale * svgHeight) / 2f + dy);

        scaleMatrix.reset();
        scaleMatrix.setScale(scale, scale);
        matrix.set(scaleMatrix);

        Matrix transform = null;

        LinkedList<Matrix> matrixList = new LinkedList<Matrix>();


        // 

        // _0

        // _0_0
        // I love SVG!
        paint.setColor(Color.argb(255, 255, 0, 0));
        path.reset();
        path.moveTo(1.1191406f, 15.0f);
        path.lineTo(1.1191406f, 6.4101562f);
        path.lineTo(2.2558594f, 6.4101562f);
        path.lineTo(2.2558594f, 15.0f);
        path.close();
        path.moveTo(7.435547f, 15.0f);
        path.lineTo(7.435547f, 6.4101562f);
        path.lineTo(8.490234f, 6.4101562f);
        path.lineTo(8.490234f, 15.0f);
        path.close();
        path.moveTo(9.732422f, 11.888672f);
        path.quadTo(9.732422f, 10.160156f, 10.693359f, 9.328125f);
        path.quadTo(11.496094f, 8.636719f, 12.650391f, 8.636719f);
        path.quadTo(13.933594f, 8.636719f, 14.748047f, 9.477539f);
        path.quadTo(15.5625f, 10.318359f, 15.5625f, 11.800781f);
        path.quadTo(15.5625f, 13.001953f, 15.202148f, 13.69043f);
        path.quadTo(14.841797f, 14.378906f, 14.15332f, 14.759766f);
        path.quadTo(13.464844f, 15.140625f, 12.650391f, 15.140625f);
        path.quadTo(11.34375f, 15.140625f, 10.538086f, 14.302734f);
        path.quadTo(9.732422f, 13.464844f, 9.732422f, 11.888672f);
        path.close();
        path.moveTo(10.816406f, 11.888672f);
        path.quadTo(10.816406f, 13.083984f, 11.337891f, 13.678711f);
        path.quadTo(11.859375f, 14.2734375f, 12.650391f, 14.2734375f);
        path.quadTo(13.435547f, 14.2734375f, 13.957031f, 13.675781f);
        path.quadTo(14.478516f, 13.078125f, 14.478516f, 11.853516f);
        path.quadTo(14.478516f, 10.699219f, 13.954102f, 10.104492f);
        path.quadTo(13.4296875f, 9.509766f, 12.650391f, 9.509766f);
        path.quadTo(11.859375f, 9.509766f, 11.337891f, 10.1015625f);
        path.quadTo(10.816406f, 10.693359f, 10.816406f, 11.888672f);
        path.close();
        path.moveTo(18.527344f, 15.0f);
        path.lineTo(16.160156f, 8.777344f);
        path.lineTo(17.273438f, 8.777344f);
        path.lineTo(18.609375f, 12.503906f);
        path.quadTo(18.826172f, 13.107422f, 19.007812f, 13.7578125f);
        path.quadTo(19.148438f, 13.265625f, 19.40039f, 12.574219f);
        path.lineTo(20.783203f, 8.777344f);
        path.lineTo(21.867188f, 8.777344f);
        path.lineTo(19.511719f, 15.0f);
        path.close();
        path.moveTo(27.058594f, 12.996094f);
        path.lineTo(28.148438f, 13.130859f);
        path.quadTo(27.890625f, 14.0859375f, 27.19336f, 14.613281f);
        path.quadTo(26.496094f, 15.140625f, 25.41211f, 15.140625f);
        path.quadTo(24.046875f, 15.140625f, 23.24707f, 14.299805f);
        path.quadTo(22.447266f, 13.458984f, 22.447266f, 11.941406f);
        path.quadTo(22.447266f, 10.371094f, 23.25586f, 9.503906f);
        path.quadTo(24.064453f, 8.636719f, 25.353516f, 8.636719f);
        path.quadTo(26.601562f, 8.636719f, 27.392578f, 9.486328f);
        path.quadTo(28.183594f, 10.3359375f, 28.183594f, 11.876953f);
        path.quadTo(28.183594f, 11.970703f, 28.177734f, 12.158203f);
        path.lineTo(23.53711f, 12.158203f);
        path.quadTo(23.595703f, 13.183594f, 24.117188f, 13.728516f);
        path.quadTo(24.638672f, 14.2734375f, 25.417969f, 14.2734375f);
        path.quadTo(25.998047f, 14.2734375f, 26.408203f, 13.96875f);
        path.quadTo(26.81836f, 13.6640625f, 27.058594f, 12.996094f);
        path.close();
        path.moveTo(23.595703f, 11.291016f);
        path.lineTo(27.070312f, 11.291016f);
        path.quadTo(27.0f, 10.505859f, 26.671875f, 10.113281f);
        path.quadTo(26.167969f, 9.503906f, 25.365234f, 9.503906f);
        path.quadTo(24.638672f, 9.503906f, 24.143555f, 9.990234f);
        path.quadTo(23.648438f, 10.4765625f, 23.595703f, 11.291016f);
        path.close();
        path.moveTo(32.554688f, 12.240234f);
        path.lineTo(33.626953f, 12.146484f);
        path.quadTo(33.703125f, 12.791016f, 33.981445f, 13.204102f);
        path.quadTo(34.259766f, 13.6171875f, 34.845703f, 13.87207f);
        path.quadTo(35.43164f, 14.126953f, 36.164062f, 14.126953f);
        path.quadTo(36.814453f, 14.126953f, 37.3125f, 13.933594f);
        path.quadTo(37.810547f, 13.740234f, 38.05371f, 13.40332f);
        path.quadTo(38.296875f, 13.066406f, 38.296875f, 12.667969f);
        path.quadTo(38.296875f, 12.263672f, 38.0625f, 11.961914f);
        path.quadTo(37.828125f, 11.660156f, 37.289062f, 11.455078f);
        path.quadTo(36.94336f, 11.3203125f, 35.759766f, 11.036133f);
        path.quadTo(34.57617f, 10.751953f, 34.101562f, 10.5f);
        path.quadTo(33.48633f, 10.177734f, 33.18457f, 9.700195f);
        path.quadTo(32.882812f, 9.222656f, 32.882812f, 8.630859f);
        path.quadTo(32.882812f, 7.9804688f, 33.251953f, 7.415039f);
        path.quadTo(33.621094f, 6.8496094f, 34.33008f, 6.5566406f);
        path.quadTo(35.039062f, 6.263672f, 35.90625f, 6.263672f);
        path.quadTo(36.86133f, 6.263672f, 37.59082f, 6.571289f);
        path.quadTo(38.320312f, 6.8789062f, 38.71289f, 7.4765625f);
        path.quadTo(39.10547f, 8.074219f, 39.134766f, 8.830078f);
        path.lineTo(38.04492f, 8.912109f);
        path.quadTo(37.95703f, 8.097656f, 37.450195f, 7.6816406f);
        path.quadTo(36.94336f, 7.265625f, 35.953125f, 7.265625f);
        path.quadTo(34.921875f, 7.265625f, 34.450195f, 7.6435547f);
        path.quadTo(33.978516f, 8.021484f, 33.978516f, 8.5546875f);
        path.quadTo(33.978516f, 9.017578f, 34.3125f, 9.316406f);
        path.quadTo(34.640625f, 9.615234f, 36.026367f, 9.928711f);
        path.quadTo(37.41211f, 10.2421875f, 37.927734f, 10.4765625f);
        path.quadTo(38.677734f, 10.822266f, 39.035156f, 11.352539f);
        path.quadTo(39.39258f, 11.8828125f, 39.39258f, 12.574219f);
        path.quadTo(39.39258f, 13.259766f, 39.0f, 13.866211f);
        path.quadTo(38.60742f, 14.472656f, 37.87207f, 14.80957f);
        path.quadTo(37.13672f, 15.146484f, 36.216797f, 15.146484f);
        path.quadTo(35.05078f, 15.146484f, 34.262695f, 14.806641f);
        path.quadTo(33.47461f, 14.466797f, 33.026367f, 13.78418f);
        path.quadTo(32.578125f, 13.1015625f, 32.554688f, 12.240234f);
        path.close();
        path.moveTo(43.40039f, 15.0f);
        path.lineTo(40.072266f, 6.4101562f);
        path.lineTo(41.302734f, 6.4101562f);
        path.lineTo(43.535156f, 12.650391f);
        path.quadTo(43.804688f, 13.400391f, 43.98633f, 14.056641f);
        path.quadTo(44.185547f, 13.353516f, 44.44922f, 12.650391f);
        path.lineTo(46.76953f, 6.4101562f);
        path.lineTo(47.929688f, 6.4101562f);
        path.lineTo(44.566406f, 15.0f);
        path.close();
        path.moveTo(52.96875f, 11.630859f);
        path.lineTo(52.96875f, 10.623047f);
        path.lineTo(56.60742f, 10.6171875f);
        path.lineTo(56.60742f, 13.8046875f);
        path.quadTo(55.76953f, 14.472656f, 54.878906f, 14.80957f);
        path.quadTo(53.98828f, 15.146484f, 53.05078f, 15.146484f);
        path.quadTo(51.785156f, 15.146484f, 50.750977f, 14.604492f);
        path.quadTo(49.716797f, 14.0625f, 49.189453f, 13.037109f);
        path.quadTo(48.66211f, 12.011719f, 48.66211f, 10.746094f);
        path.quadTo(48.66211f, 9.4921875f, 49.186523f, 8.405273f);
        path.quadTo(49.710938f, 7.3183594f, 50.695312f, 6.7910156f);
        path.quadTo(51.679688f, 6.263672f, 52.96289f, 6.263672f);
        path.quadTo(53.89453f, 6.263672f, 54.64746f, 6.5654297f);
        path.quadTo(55.40039f, 6.8671875f, 55.828125f, 7.40625f);
        path.quadTo(56.25586f, 7.9453125f, 56.478516f, 8.8125f);
        path.lineTo(55.453125f, 9.09375f);
        path.quadTo(55.259766f, 8.4375f, 54.972656f, 8.0625f);
        path.quadTo(54.685547f, 7.6875f, 54.152344f, 7.461914f);
        path.quadTo(53.61914f, 7.236328f, 52.96875f, 7.236328f);
        path.quadTo(52.189453f, 7.236328f, 51.621094f, 7.473633f);
        path.quadTo(51.052734f, 7.7109375f, 50.7041f, 8.097656f);
        path.quadTo(50.35547f, 8.484375f, 50.16211f, 8.947266f);
        path.quadTo(49.833984f, 9.744141f, 49.833984f, 10.675781f);
        path.quadTo(49.833984f, 11.824219f, 50.229492f, 12.597656f);
        path.quadTo(50.625f, 13.371094f, 51.38086f, 13.746094f);
        path.quadTo(52.13672f, 14.121094f, 52.98633f, 14.121094f);
        path.quadTo(53.72461f, 14.121094f, 54.427734f, 13.836914f);
        path.quadTo(55.13086f, 13.552734f, 55.49414f, 13.230469f);
        path.lineTo(55.49414f, 11.630859f);
        path.close();
        path.moveTo(58.710938f, 12.8671875f);
        path.lineTo(58.38867f, 8.314453f);
        path.lineTo(58.38867f, 6.4101562f);
        path.lineTo(59.695312f, 6.4101562f);
        path.lineTo(59.695312f, 8.314453f);
        path.lineTo(59.390625f, 12.8671875f);
        path.close();
        path.moveTo(58.435547f, 15.0f);
        path.lineTo(58.435547f, 13.798828f);
        path.lineTo(59.648438f, 13.798828f);
        path.lineTo(59.648438f, 15.0f);
        path.close();
        applyTransform(matrixList);
        path.transform(matrix);
        canvas.drawPath(path, paint);

        canvas.restore();
    }

    /**
     * Tint the svg with the specified color, All parts of the svg will show the color.
     *
     * @param color the color that used to tint the svg
     **/
    public void setColorTint(int color){
        colorFilter = new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN);
    }

    /**
     * Clear the color tint for the svg, it will be drawn with the original color in the svg file.
     **/
    public void clearColorTint(int color){
        colorFilter = null;
    }

    private void applyTransform(LinkedList<Matrix> matrixList) {
        if (matrixList.peek() != null) {
            matrix.set(matrixList.peek());
            matrix.postConcat(scaleMatrix);
        } else {
            matrix.set(scaleMatrix);
        }
    }

    private void resetPaint() {
        paint.reset();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);

        strokePaint.reset();
        strokePaint.setAntiAlias(true);
        strokePaint.setStyle(Paint.Style.STROKE);

        if (colorFilter != null) {
            paint.setColorFilter(colorFilter);
            strokePaint.setColorFilter(colorFilter);
        }
    }
}

