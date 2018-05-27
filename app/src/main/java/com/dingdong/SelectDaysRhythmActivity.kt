package com.dingdong

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_select_days_rhythm.*

class SelectDaysRhythmActivity : AppCompatActivity() {

    /*
    lateinit var shortM : NumberPicker
    lateinit var longM : NumberPicker
    lateinit var lsYM : NumberPicker
    lateinit var lsMM : NumberPicker
    lateinit var lsDM : NumberPicker
    */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_days_rhythm)
        /*
        shortM = findViewById(R.id.np_short_magic)
        longM = findViewById(R.id.np_long_magic)
        lsYM = findViewById(R.id.np_last_start_magic_year)
        lsMM = findViewById(R.id.np_last_start_magic_month)
        lsDM = findViewById(R.id.np_last_start_magic_day)
        */

        np_short_magic.minValue = 0
        np_short_magic.maxValue = 365

        np_long_magic.minValue = 0
        np_long_magic.maxValue = 365

        np_last_start_magic_year.minValue = 2017
        np_last_start_magic_year.maxValue = 2018

        np_last_start_magic_month.minValue = 1
        np_last_start_magic_month.maxValue = 12

        np_last_start_magic_day.minValue = 1
        np_last_start_magic_day.maxValue = 31

        btn_next_get.setOnClickListener {
            val intent = Intent(this, SelectDaysStandard::class.java)
            startActivity(intent)
        }
    }
}