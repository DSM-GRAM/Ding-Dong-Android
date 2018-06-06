package com.wheelviewlib.transformer;

import android.graphics.Rect;

import com.wheelviewlib.Circle;
import com.wheelviewlib.WheelView;

public class SimpleItemTransformer implements WheelItemTransformer {
    @Override
    public void transform(WheelView.ItemState itemState, Rect itemBounds) {
        Circle bounds = itemState.getBounds();
        float radius = bounds.getRadius();
        float x = bounds.getCenterX();
        float y = bounds.getCenterY();
        itemBounds.set(Math.round(x - radius), Math.round(y - radius), Math.round(x + radius), Math.round(y + radius));
    }
}
