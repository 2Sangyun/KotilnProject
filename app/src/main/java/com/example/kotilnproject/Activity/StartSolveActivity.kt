package com.example.kotilnproject.Activity

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.kotilnproject.DataBase.History
import com.example.kotilnproject.DataBase.HistoryDatabase
import com.example.kotilnproject.LiveData.MyAnswers
import com.example.kotilnproject.R
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
    var leftTime : Int  = 60
    var minute : Int = 0
    var second : Int = 0

    @RequiresApi(Build.VERSION_CODES.O)
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

    @RequiresApi(Build.VERSION_CODES.O)
    private fun startTimer(){
        timerTask = kotlin.concurrent.timer(period = 1000, initialDelay = 0){
            minute = leftTime / 60
            second = leftTime % 60

            runOnUiThread{
                time.text = String.format("%02d : %02d", minute, second)
            }

            if(leftTime == 30){

                val channel_id = "test_app_channel"
                val channel_name = "test_app"
                val channel_description = "this is test_app"
                val importance = NotificationManager.IMPORTANCE_DEFAULT
                val channel = NotificationChannel(channel_id, channel_name, importance).apply{
                    description = channel_description
                }

                var builder = NotificationCompat.Builder(application, channel_id)
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setContentTitle("Test App Notification")
                    .setContentText("시험 종료 30초전 입니다.")

                val notificationManager : NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as
                        NotificationManager
                notificationManager.createNotificationChannel(channel)

                notificationManager.notify(99, builder.build())
            }
            leftTime -= 1
        }

    }

    override fun onClick(view: View?) {

        var score : Int  = checkAnswer()
        CoroutineScope(Dispatchers.IO).launch {
            db.historyDao().insertAll(
                History(
                0,
                myAnswers.question1_answer.value.toString(),
                myAnswers.question2_answer.value.toString(),
                myAnswers.question3_answer.value.toString(),
                    score,
            )
            )
        }

        val intent = Intent(this, ShowResultActivity::class.java)

        intent.putExtra("score", score)
        startActivity(intent)
    }

    fun checkAnswer() : Int {
        var score : Int = 0
        if (myAnswers.question1_answer.value.toString() == "2"){
            score += 1
        }
        if (myAnswers.question2_answer.value.toString() == "1"){
            score += 1
        }
        if (myAnswers.question3_answer.value.toString() == "4"){
            score += 1
        }
       return score
    }

}
