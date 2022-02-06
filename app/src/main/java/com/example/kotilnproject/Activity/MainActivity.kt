package com.example.kotilnproject.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.kotilnproject.DataBase.HistoryDatabase
import com.example.kotilnproject.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener{

    lateinit var db : HistoryDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = HistoryDatabase.getInstance(this)!!

        start_btn.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view){
            start_btn -> {
                val intent = Intent(this, StartSolveActivity::class.java)
                startActivity(intent)
            }
        }
    }

}