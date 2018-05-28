package com.dingdong

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.graphics.Typeface.BOLD
import android.text.style.ForegroundColorSpan
import android.text.SpannableStringBuilder
import android.text.style.AbsoluteSizeSpan
import android.text.style.StyleSpan
import kotlinx.android.synthetic.main.activity_sign_up.*


class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        val cycleString = "평균 월경주기는 25~35일 입니다."
        val cycleChangeColor = SpannableStringBuilder(cycleString)
        cycleChangeColor.setSpan(ForegroundColorSpan(Color.parseColor("#ff717c")), 9, 14, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        cycleChangeColor.setSpan(AbsoluteSizeSpan(60), 9, 14, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        cycleChangeColor.setSpan(StyleSpan(BOLD), 9, 14, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        text_cycle.text = cycleChangeColor

        btn_next.setOnClickListener {
            val intent = Intent(this, SelectCalculationActivity::class.java)
            startActivity(intent)
        }
    }
}
