package com.github.furutuki.androidsvgtranscoder.sample.svgobj;

// TODO Include your package name here

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class LineDrawable {
    private static final Paint  p  = new Paint();
    private static final Paint  ps = new Paint();
    private static final Path   t  = new Path();
    private static final Matrix m  = new Matrix();
    private static float od;
    protected static ColorFilter cf = null;

    /**
     *  IMPORTANT: Due to the static usage of this class this
     *  method sets the tint color statically. So it is highly
     *  recommended to call the clearColorTint method when you
     *  have finished drawing.
     *
     *  Sets the color to use when drawing the SVG. This replaces
     *  all parts of the drawable which are not completely
     *  transparent with this color.
     */
    public static void setColorTint(int color){
        cf = new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN);
    }

    public static void clearColorTint(int color){
        cf = null;
    }

    public static void draw(Canvas c, int w, int h){
        draw(c, w, h, 0, 0);
    }

    public static void draw(Canvas c, int w, int h, int dx, int dy){
        float ow = 500f;
        float oh = 210f;

        od = (w / ow < h / oh) ? w / ow : h / oh;

        r();
        c.save();
        c.translate((w - od * ow) / 2f + dx, (h - od * oh) / 2f + dy);

        m.reset();
        m.setScale(od, od);

        c.save();
        ps.setColor(Color.argb(0,0,0,0));
        ps.setStrokeCap(Paint.Cap.BUTT);
        ps.setStrokeJoin(Paint.Join.MITER);
        ps.setStrokeMiter(4.0f*od);
        c.save();
        ps.setColor(Color.rgb(255,0,0));
        ps.setStrokeWidth(2.0f*od);
        t.reset();
        t.moveTo(0.0f,0.0f);
        t.lineTo(200.0f,200.0f);
        t.transform(m);
        c.drawPath(t, p);
        c.drawPath(t, ps);
        c.restore();
        r(1,3,0,2);
        ps.setColor(Color.rgb(255,0,0));
        ps.setStrokeWidth(2.0f*od);
        c.restore();
        r();

        c.restore();
    }

    public static Drawable getDrawable(int size){
        return new SvgObjectDrawable(size);
    }

    public static Drawable getTintedDrawable(int size, int color){
        return new SvgObjectDrawable(size, color);
    }

    private static class SvgObjectDrawable extends Drawable {
        private int s = 0;
        private ColorFilter cf = null;

        public SvgObjectDrawable(int s) {
            this.s = s;
            setBounds(0, 0, s, s);
            invalidateSelf();
        }

        public SvgObjectDrawable(int s, int c) {
            this(s);
            cf = new PorterDuffColorFilter(c, PorterDuff.Mode.SRC_IN);
        }

        @Override
        public int getIntrinsicHeight() {
            return s;
        }

        @Override
        public int getIntrinsicWidth() {
            return s;
        }

        @Override
        public void draw(Canvas c) {
            Rect b = getBounds();
            LineDrawable.cf = cf;
            LineDrawable.draw(c, b.width(), b.height(), b.left, b.top);
            LineDrawable.cf = null;
        }

        @Override
        public void setAlpha(int i) {}

        @Override
        public void setColorFilter(ColorFilter c) { cf = c; invalidateSelf(); }

        @Override
        public int getOpacity() {
            return PixelFormat.UNKNOWN;
        }
    }

    private static void r(Integer... o){
        p.reset();
        ps.reset();
        if(cf != null){
            p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        p.setAntiAlias(true);
        ps.setAntiAlias(true);
        p.setStyle(Paint.Style.FILL);
        ps.setStyle(Paint.Style.STROKE);
        for(Integer i : o){
            switch (i){
                case 0: ps.setStrokeJoin(Paint.Join.MITER); break;
                case 1: ps.setColor(Color.argb(0,0,0,0)); break;
                case 2: ps.setStrokeMiter(4.0f*od); break;
                case 3: ps.setStrokeCap(Paint.Cap.BUTT); break;
            }
        }
    }
};
