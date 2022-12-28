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
public class Polyline2 {

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
		transform.setValues(new float[]{0.005f, 0, 0, 0, 0.005f, 0.25f, 0, 0, 1});

        matrixList.push(transform);

        // _0

        // _0_0
        path.reset();
        path.moveTo(0.0f, 100.0f);
        path.lineTo(50.0f, 25.0f);
        path.lineTo(50.0f, 75.0f);
        path.lineTo(100.0f, 0.0f);
        applyTransform(matrixList);
        path.transform(matrix);
        paint.setColor(Color.argb(255, 0, 0, 0));
        canvas.drawPath(path, paint);


        // _0_1
        path.reset();
        path.moveTo(100.0f, 100.0f);
        path.lineTo(150.0f, 25.0f);
        path.lineTo(150.0f, 75.0f);
        path.lineTo(200.0f, 0.0f);
        applyTransform(matrixList);
        path.transform(matrix);
        strokePaint.setColor(Color.argb(255, 0, 0, 0));
        strokePaint.setStrokeWidth(1.0f);
        strokePaint.setStrokeCap(Paint.Cap.BUTT);
        strokePaint.setStrokeJoin(Paint.Join.MITER);
        strokePaint.setStrokeMiter(4.0f);
        strokePaint.setPathEffect(null);
        canvas.drawPath(path, strokePaint);


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

