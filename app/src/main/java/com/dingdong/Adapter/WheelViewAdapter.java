package com.dingdong.Adapter;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;

import com.wheelviewlib.adapter.WheelArrayAdapter;

import java.util.List;

public class WheelViewAdapter {
    public static Drawable[] drawable;

    public static class MaterialColorAdapter extends WheelArrayAdapter<Integer> {
        public MaterialColorAdapter(List<Integer> items) {
            super(items);
        }

        @Override
        public Drawable getDrawable(int position) {
            Drawable[] drawable = new Drawable[] {
                    //createOvalDrawable(-1),
                    new TextDrawable(String.valueOf(position+1))
            };
            return new LayerDrawable(drawable);
        }

        /*private Drawable createOvalDrawable(int color) {
            ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
            shapeDrawable.getPaint().setColor(color);
            return shapeDrawable;
        }*/
    }
}

class TextDrawable extends Drawable {

    private final String text;
    private final Paint paint;

    public TextDrawable(String text) {

        this.text = text;

        this.paint = new Paint();
        //paint.setColor(Color.WHITE);
        paint.setColor(Color.BLACK);
        paint.setTextSize(52f);
        paint.setAntiAlias(true);
        paint.setFakeBoldText(true);
        //paint.setShadowLayer(12f, 0, 0, Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextAlign(Paint.Align.LEFT);
    }

    @Override
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.drawText(text, bounds.centerX() - 15f /*just a lazy attempt to centre the text*/ * text.length(), bounds.centerY() + 15f, paint);
    }

    @Override
    public void setAlpha(int alpha) {
        paint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
        paint.setColorFilter(cf);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    public String getText() {
        return text;
    }
}