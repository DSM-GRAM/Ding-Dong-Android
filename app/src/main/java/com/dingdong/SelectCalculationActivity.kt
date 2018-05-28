package com.dingdong

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_select_calculation.*

class SelectCalculationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_calculation)

        if(radiobtn_rhythm.isChecked()) {
            radiobtn_standard.isChecked
        }
    }
}
