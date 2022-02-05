package com.example.kotilnproject

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.activity_start_solve.*
import kotlinx.android.synthetic.main.question1_fragment.*
import com.example.kotilnproject.StartSolveActivity as StartSolveActivity

class Question1 : Fragment() {
    private val viewModel : MyAnswers by activityViewModels()
    lateinit var navController : NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.question1_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //viewModel = ViewModelProvider(this).get(MyAnswers::class.java)
        viewModel.question1_answer.observe(viewLifecycleOwner, Observer { })

        if (viewModel.question1_answer.value != "선택안함"){
            when(viewModel.question1_answer.value){
                "1"-> radio_btn_q1_1.isChecked = true
                "2"-> radio_btn_q1_2.isChecked = true
                "3"-> radio_btn_q1_3.isChecked = true
                "4"-> radio_btn_q1_4.isChecked = true
            }
        }

        navController = Navigation.findNavController(view)

        btn_next_q1.setOnClickListener {
            navController.navigate(R.id.action_quesition1_to_question2)
        }

        radio_group_q1.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.radio_btn_q1_1 ->
                    viewModel.updateValue(1,"1")
                R.id.radio_btn_q1_2 ->
                    viewModel.updateValue(1,"2")
                R.id.radio_btn_q1_3 ->
                    viewModel.updateValue(1,"3")
                R.id.radio_btn_q1_4 ->
                    viewModel.updateValue(1,"4")
            }
        }
    }

}