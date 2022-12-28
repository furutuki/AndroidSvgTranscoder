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
public class PathCanvas {

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
        float svgWidth = 349f;
        float svgHeight= 337f;

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
        path.reset();
        path.moveTo(100.0f, 350.0f);
        path.lineTo(250.0f, 50.0f);
        applyTransform(matrixList);
        path.transform(matrix);
        strokePaint.setColor(Color.argb(255, 255, 0, 0));
        strokePaint.setStrokeWidth(3.0f);
        strokePaint.setStrokeCap(Paint.Cap.BUTT);
        strokePaint.setStrokeJoin(Paint.Join.MITER);
        strokePaint.setStrokeMiter(4.0f);
        strokePaint.setPathEffect(null);
        canvas.drawPath(path, strokePaint);


        // _0_1
        path.reset();
        path.moveTo(250.0f, 50.0f);
        path.lineTo(400.0f, 350.0f);
        applyTransform(matrixList);
        path.transform(matrix);
        strokePaint.setColor(Color.argb(255, 255, 0, 0));
        strokePaint.setStrokeWidth(3.0f);
        strokePaint.setStrokeCap(Paint.Cap.BUTT);
        strokePaint.setStrokeJoin(Paint.Join.MITER);
        strokePaint.setStrokeMiter(4.0f);
        strokePaint.setPathEffect(null);
        canvas.drawPath(path, strokePaint);


        // _0_2
        path.reset();
        path.moveTo(175.0f, 200.0f);
        path.lineTo(325.0f, 200.0f);
        applyTransform(matrixList);
        path.transform(matrix);
        strokePaint.setColor(Color.argb(255, 0, 128, 0));
        strokePaint.setStrokeWidth(3.0f);
        strokePaint.setStrokeCap(Paint.Cap.BUTT);
        strokePaint.setStrokeJoin(Paint.Join.MITER);
        strokePaint.setStrokeMiter(4.0f);
        strokePaint.setPathEffect(null);
        canvas.drawPath(path, strokePaint);


        // _0_3
        path.reset();
        path.moveTo(100.0f, 350.0f);
        path.quadTo(250.0f, 50.0f, 400.0f, 350.0f);
        applyTransform(matrixList);
        path.transform(matrix);
        strokePaint.setColor(Color.argb(255, 0, 0, 255));
        strokePaint.setStrokeWidth(5.0f);
        strokePaint.setStrokeCap(Paint.Cap.BUTT);
        strokePaint.setStrokeJoin(Paint.Join.MITER);
        strokePaint.setStrokeMiter(4.0f);
        strokePaint.setPathEffect(null);
        canvas.drawPath(path, strokePaint);


        // _0_4

        // _0_4_0
        path.reset();
        path.addOval(97.0f, 347.0f, 103.0f, 353.0f, Path.Direction.CW);
        applyTransform(matrixList);
        path.transform(matrix);
        paint.setColor(Color.argb(255, 0, 0, 0));
        canvas.drawPath(path, paint);

        strokePaint.setColor(Color.argb(255, 0, 0, 0));
        strokePaint.setStrokeWidth(3.0f);
        strokePaint.setStrokeCap(Paint.Cap.BUTT);
        strokePaint.setStrokeJoin(Paint.Join.MITER);
        strokePaint.setStrokeMiter(4.0f);
        strokePaint.setPathEffect(null);
        canvas.drawPath(path, strokePaint);


        // _0_4_1
        path.reset();
        path.addOval(247.0f, 47.0f, 253.0f, 53.0f, Path.Direction.CW);
        applyTransform(matrixList);
        path.transform(matrix);
        paint.setColor(Color.argb(255, 0, 0, 0));
        canvas.drawPath(path, paint);

        strokePaint.setColor(Color.argb(255, 0, 0, 0));
        strokePaint.setStrokeWidth(3.0f);
        strokePaint.setStrokeCap(Paint.Cap.BUTT);
        strokePaint.setStrokeJoin(Paint.Join.MITER);
        strokePaint.setStrokeMiter(4.0f);
        strokePaint.setPathEffect(null);
        canvas.drawPath(path, strokePaint);


        // _0_4_2
        path.reset();
        path.addOval(397.0f, 347.0f, 403.0f, 353.0f, Path.Direction.CW);
        applyTransform(matrixList);
        path.transform(matrix);
        paint.setColor(Color.argb(255, 0, 0, 0));
        canvas.drawPath(path, paint);

        strokePaint.setColor(Color.argb(255, 0, 0, 0));
        strokePaint.setStrokeWidth(3.0f);
        strokePaint.setStrokeCap(Paint.Cap.BUTT);
        strokePaint.setStrokeJoin(Paint.Join.MITER);
        strokePaint.setStrokeMiter(4.0f);
        strokePaint.setPathEffect(null);
        canvas.drawPath(path, strokePaint);


        // _0_5

        // _0_5_0
        // A
        paint.setColor(Color.argb(255, 0, 0, 0));
        path.reset();
        path.moveTo(88.43506f, 341.70898f);
        path.lineTo(84.74365f, 332.36328f);
        path.lineTo(81.0376f, 341.70898f);
        path.close();
        path.moveTo(91.68701f, 350.0f);
        path.lineTo(89.32861f, 343.99414f);
        path.lineTo(80.14404f, 343.99414f);
        path.lineTo(77.75635f, 350.0f);
        path.lineTo(74.8999f, 350.0f);
        path.lineTo(83.498535f, 328.3203f);
        path.lineTo(86.54541f, 328.3203f);
        path.lineTo(95.01221f, 350.0f);
        path.close();
        applyTransform(matrixList);
        path.transform(matrix);
        canvas.drawPath(path, paint);

        // _0_5_1
        // B
        paint.setColor(Color.argb(255, 0, 0, 0));
        path.reset();
        path.moveTo(244.16992f, 40.0f);
        path.lineTo(244.16992f, 18.320312f);
        path.lineTo(249.79492f, 18.320312f);
        path.quadTo(253.04688f, 18.320312f, 254.78271f, 19.550781f);
        path.quadTo(256.51855f, 20.78125f, 256.51855f, 23.095703f);
        path.quadTo(256.51855f, 27.036133f, 252.06543f, 28.706055f);
        path.quadTo(257.3828f, 30.332031f, 257.3828f, 34.58008f);
        path.quadTo(257.3828f, 37.216797f, 255.625f, 38.6084f);
        path.quadTo(253.86719f, 40.0f, 250.55664f, 40.0f);
        path.close();
        path.moveTo(247.2168f, 37.700195f);
        path.lineTo(247.84668f, 37.700195f);
        path.quadTo(251.23047f, 37.700195f, 252.22656f, 37.27539f);
        path.quadTo(254.13086f, 36.469727f, 254.13086f, 34.28711f);
        path.quadTo(254.13086f, 32.353516f, 252.40234f, 31.071777f);
        path.quadTo(250.67383f, 29.79004f, 248.08105f, 29.79004f);
        path.lineTo(247.2168f, 29.79004f);
        path.close();
        path.moveTo(247.2168f, 27.841797f);
        path.lineTo(248.19824f, 27.841797f);
        path.quadTo(250.65918f, 27.841797f, 252.01416f, 26.78711f);
        path.quadTo(253.36914f, 25.732422f, 253.36914f, 23.813477f);
        path.quadTo(253.36914f, 20.620117f, 248.41797f, 20.620117f);
        path.lineTo(247.2168f, 20.620117f);
        path.close();
        applyTransform(matrixList);
        path.transform(matrix);
        canvas.drawPath(path, paint);

        // _0_5_2
        // C
        paint.setColor(Color.argb(255, 0, 0, 0));
        path.reset();
        path.moveTo(416.70654f, 350.542f);
        path.quadTo(411.65283f, 350.542f, 408.89893f, 347.57568f);
        path.quadTo(406.14502f, 344.60938f, 406.14502f, 339.1748f);
        path.quadTo(406.14502f, 333.75488f, 408.9502f, 330.7666f);
        path.quadTo(411.75537f, 327.77832f, 416.85303f, 327.77832f);
        path.quadTo(419.76807f, 327.77832f, 423.6792f, 328.73047f);
        path.lineTo(423.6792f, 331.6162f);
        path.quadTo(419.22607f, 330.07812f, 416.80908f, 330.07812f);
        path.quadTo(413.2788f, 330.07812f, 411.3452f, 332.46582f);
        path.quadTo(409.41162f, 334.85352f, 409.41162f, 339.2041f);
        path.quadTo(409.41162f, 343.3496f, 411.47705f, 345.74463f);
        path.quadTo(413.54248f, 348.13965f, 417.1167f, 348.13965f);
        path.quadTo(420.19287f, 348.13965f, 423.7085f, 346.25f);
        path.lineTo(423.7085f, 348.88672f);
        path.quadTo(420.5005f, 350.542f, 416.70654f, 350.542f);
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

