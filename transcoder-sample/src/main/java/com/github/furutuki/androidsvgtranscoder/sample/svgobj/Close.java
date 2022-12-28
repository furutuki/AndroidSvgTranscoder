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
 * This class is generated automatically by using AndroidSvgTranscoder.
 *
 * @author furutuki furutuki@foxmail.com
 */
public class Close {

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
        float svgWidth = 1f;
        float svgHeight= 1f;

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
        transform = new Matrix();
		transform.setValues(new float[]{0.0070459f, 0, 0, 0, 0.0070459f, 0, 0, 0, 1});

        matrixList.push(transform);

        // _0

        // _0_0
        path.reset();
        path.moveTo(4.2577953f, 3.1642516f);
        path.lineTo(4.2577953f, 3.1642516f);
        path.lineTo(4.2577953f, 3.1642516f);
        path.lineTo(4.2577953f, 3.1642516f);
        path.quadTo(5.6770606f, 1.7449864f, 8.515591f, 1.7449864f);
        path.quadTo(11.354121f, 1.7449864f, 12.773386f, 3.1642516f);
        path.lineTo(12.773386f, 3.1642516f);
        path.lineTo(70.96326f, 61.354122f);
        path.lineTo(129.15312f, 3.1642516f);
        path.quadTo(130.57239f, 1.7449864f, 133.41092f, 1.7449864f);
        path.quadTo(136.24945f, 1.7449864f, 138.37834f, 3.8738842f);
        path.quadTo(140.50725f, 6.002782f, 140.50725f, 8.13168f);
        path.quadTo(140.50725f, 10.260577f, 137.66872f, 13.099108f);
        path.lineTo(137.66872f, 13.099108f);
        path.lineTo(79.47884f, 71.28898f);
        path.lineTo(137.66872f, 129.47885f);
        path.quadTo(140.50725f, 130.89812f, 140.50725f, 133.02701f);
        path.quadTo(140.50725f, 135.15591f, 139.08798f, 137.99443f);
        path.lineTo(139.08798f, 137.99443f);
        path.lineTo(137.66872f, 137.99443f);
        path.quadTo(136.24945f, 139.4137f, 133.41092f, 139.4137f);
        path.quadTo(130.57239f, 139.4137f, 129.15312f, 137.99443f);
        path.lineTo(129.15312f, 137.99443f);
        path.lineTo(70.96326f, 79.804565f);
        path.lineTo(12.773386f, 137.99443f);
        path.quadTo(11.354121f, 139.4137f, 8.515591f, 139.4137f);
        path.quadTo(5.6770606f, 139.4137f, 3.5481627f, 137.99443f);
        path.quadTo(1.4192652f, 136.57516f, 1.4192652f, 133.73665f);
        path.quadTo(1.4192652f, 130.89812f, 4.2577953f, 129.47885f);
        path.lineTo(4.2577953f, 129.47885f);
        path.lineTo(62.447666f, 71.28898f);
        path.lineTo(4.2577953f, 13.099108f);
        path.quadTo(2.8385303f, 11.679842f, 2.1288977f, 8.841312f);
        path.quadTo(1.4192652f, 6.002782f, 4.2577953f, 3.1642516f);
        path.close();
        applyTransform(matrixList);
        path.transform(matrix);
        paint.setColor(Color.argb(255, 0, 0, 0));
        canvas.drawPath(path, paint);


        matrixList.pop();

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
    public void clearColorTint(){
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

