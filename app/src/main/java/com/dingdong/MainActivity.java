package com.dingdong;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.dingdong.Adapter.WheelViewAdapter;
import com.wheelviewlib.WheelView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int ITEM_COUNT = 31;
    private int[] dayAngle = new int[ITEM_COUNT];
    WheelView wheelView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dayAngle = getResources().getIntArray(R.array.day_angle);

        wheelView = (WheelView) findViewById(R.id.wheelview);
        //create data for the adapter
        ArrayList<Integer> entries = new ArrayList<>();
        for(int i = 0; i < ITEM_COUNT; i++){ entries.add(-1); }
        //populate the adapter, that knows how to draw each item (as you would do with a ListAdapter)
        wheelView.setAdapter(new WheelViewAdapter.MaterialColorAdapter(entries));

        wheelView.setOnWheelItemSelectedListener(new WheelView.OnWheelItemSelectListener() {
            @Override
            public void onWheelItemSelected(WheelView parent, Drawable itemDrawable, int position) {
                Log.e("WV Position Data", String.valueOf(position) + " "+ wheelView.getAngleForPosition(position) + " " +
                        wheelView.getSelectionAngle() + " " + wheelView.getAngle());
            }
        });

        wheelView.setOnWheelAngleChangeListener(new WheelView.OnWheelAngleChangeListener() {
            @Override
            public void onWheelAngleChange(float angle) { }
        });
    }
}