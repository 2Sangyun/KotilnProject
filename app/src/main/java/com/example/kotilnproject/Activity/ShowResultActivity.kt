package com.example.kotilnproject.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotilnproject.R
import kotlinx.android.synthetic.main.activity_show_result.*

class ShowResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_result)

        var getInfo : Intent = getIntent()
        var score = getInfo.extras?.get("score")

        txt_your_result.text = score.toString() + "/3"

        go_to_end_btn.setOnClickListener {
            var intent = Intent(this, EndActivity::class.java)
            startActivity(intent)
        }
    }
}