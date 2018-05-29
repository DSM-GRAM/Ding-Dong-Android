package com.dingdong

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_select_calculation.*

class SelectCalculationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_calculation)

        btn_next_select_caculation.setOnClickListener {

            if (radiobtn_rhythm.isChecked) {
                val intent = Intent(this, SelectDaysRhythmActivity::class.java)
                startActivity(intent)
            }

            if (radiobtn_standard.isChecked) {
                val intent = Intent(this, SelectDaysStandardActivity::class.java)
                startActivity(intent)
            }

        }
    }
}
