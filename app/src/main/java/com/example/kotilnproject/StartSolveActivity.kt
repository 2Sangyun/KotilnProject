package com.example.kotilnproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_start_solve.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class StartSolveActivity : AppCompatActivity(), View.OnClickListener {

    var timerTask : Timer? = null
    lateinit var navController : NavController
    lateinit var myAnswers: MyAnswers
    lateinit var db : HistoryDatabase

    lateinit var time : TextView
    var leftTime : Int  = 180
    var minute : Int = 0
    var second : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_solve)

        // fragment navigation
        navController =  nav_host_fragment.findNavController()

        // Timer
        time  = findViewById(R.id.txtview_timer)
        startTimer()

        // ModelView - LiveData
        myAnswers = ViewModelProvider(this).get(MyAnswers::class.java)

        myAnswers.question1_answer.observe(this, androidx.lifecycle.Observer {
            your_answer_q1.text = it.toString()
        })
        myAnswers.question2_answer.observe(this, androidx.lifecycle.Observer {
            your_answer_q2.text = it.toString()
        })
        myAnswers.question3_answer.observe(this, androidx.lifecycle.Observer {
            your_answer_q3.text = it.toString()
        })

        // Button Click Listener
        end_btn.setOnClickListener(this)

        // DB Access
        db = HistoryDatabase.getInstance(this)!!
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

    override fun onClick(view: View?) {
        CoroutineScope(Dispatchers.IO).launch {
            db.historyDao().insertAll(History(
                0,
                myAnswers.question1_answer.toString(),
                myAnswers.question2_answer.toString(),
                myAnswers.question3_answer.toString(),
                2
            ))
        }


        val intent = Intent(this, EndActivity::class.java)
        startActivity(intent)
    }

}
