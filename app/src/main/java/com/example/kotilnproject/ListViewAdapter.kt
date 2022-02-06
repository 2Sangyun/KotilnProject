package com.example.kotilnproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.BaseAdapter
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope

class ListViewAdapter(val context: Context, val history_list: List<History>) : BaseAdapter() {
    override fun getCount(): Int {
        return history_list.size
    }

    override fun getItem(p0: Int): Any {
        return history_list[p0]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent : ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.test_result, null)

        val txt_test_id = view.findViewById<TextView>(R.id.txt_test_id)
        val txt_test_score = view.findViewById<TextView>(R.id.txt_test_score)

        val cur_history = history_list[position]

        txt_test_id.text = cur_history.test_id.toString()
        txt_test_score.text = cur_history.score.toString()

        return view
    }


}