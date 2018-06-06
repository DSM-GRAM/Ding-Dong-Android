package com.wheelviewlib.transformer;

import android.graphics.drawable.Drawable;
import com.wheelviewlib.WheelView;

public interface WheelSelectionTransformer {
    void transform(Drawable drawable, WheelView.ItemState itemState);
}
