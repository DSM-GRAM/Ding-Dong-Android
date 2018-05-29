package com.dingdong

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.squareup.timessquare.CalendarPickerView
import kotlinx.android.synthetic.main.activity_select_days_standard.*
import java.util.*

class SelectDaysStandardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_days_standard)

        val today: Date = Date()
        val minDate : Calendar = Calendar.getInstance()
        minDate.add(Calendar.MONTH, -5)

        calendar_select.init(minDate.time, Calendar.getInstance().time).inMode(CalendarPickerView.SelectionMode.MULTIPLE).withSelectedDate(minDate.time)

        calendar_select.setOnDateSelectedListener(object : CalendarPickerView.OnDateSelectedListener {
            override fun onDateSelected(date: Date?) {
//                val calSelected: Calendar = Calendar.getInstance()
//                calSelected.time = date

//                val selectedDate: String = "" + calSelected.get(Calendar.DAY_OF_MONTH) + "" + (calSelected.get(Calendar.MONTH) + 1) + "" + calSelected.get(Calendar.YEAR)

            }

            override fun onDateUnselected(date: Date?) {

            }
        })
    }
}
