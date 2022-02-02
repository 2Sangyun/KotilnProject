package com.example.kotilnproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.kotilnproject.R.id
import kotlinx.android.synthetic.main.activity_start_solve.*
import java.util.*
import kotlin.concurrent.timer

class StartSolveActivity : AppCompatActivity() {

    var timerTask : Timer? = null
    lateinit var navController : NavController

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
