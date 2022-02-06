package com.example.kotilnproject.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.BaseAdapter
import com.example.kotilnproject.DataBase.History
import com.example.kotilnproject.DataBase.HistoryDatabase
import com.example.kotilnproject.ListViewAdapter
import com.example.kotilnproject.R
import kotlinx.android.synthetic.main.activity_end.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EndActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var db : HistoryDatabase
    lateinit var test_history : List<History>
    lateinit var result_adapter : BaseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)

        db = HistoryDatabase.getInstance(this)!!
        CoroutineScope(Dispatchers.IO).launch {
            test_history = db.historyDao().getAll()

            result_adapter = ListViewAdapter(application, test_history)
            result_list_view.adapter = result_adapter
        }

        back_to_start_btn.setOnClickListener(this)


    }

    override fun onClick(view: View?) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}