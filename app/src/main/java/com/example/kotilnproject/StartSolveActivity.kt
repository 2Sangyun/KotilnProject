package com.example.kotilnproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_start_solve.*
import java.util.*

class StartSolveActivity : AppCompatActivity() {

    var timerTask : Timer? = null
    lateinit var navController : NavController
    lateinit var myAnswers: MyAnswers

    lateinit var time : TextView
    var leftTime : Int  = 180
    var minute : Int = 0
    var second : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_solve)

        navController =  nav_host_fragment.findNavController()
        time  = findViewById(R.id.txtview_timer)
        startTimer()

        myAnswers = ViewModelProvider(this).get(MyAnswers::class.java)

        myAnswers.question1_answer.observe(this, androidx.lifecycle.Observer {
            your_answer_q1.text = it.toString()
        })
    }

    private fun startTimer(){
        timerTask = kotlin.concurrent.timer(period = 1000, initialDelay = 0){
            minute = leftTime / 60
            second = leftTime % 60

            runOnUiThread{
                time.text = String.format("%02d : %02d", minute, second)
            }
            leftTime -= 1
        }

    }

}
