package com.example.kotilnproject

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.question1_fragment.*
import kotlinx.android.synthetic.main.question2_fragment.*

class Question2 : Fragment() {
    private val viewModel : MyAnswers by activityViewModels()
    lateinit var navController : NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.question2_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.question2_answer.observe(viewLifecycleOwner, Observer { })

        if (viewModel.question2_answer.value != "선택안함"){
            when(viewModel.question2_answer.value){
                "1"-> radio_btn_q2_1.isChecked = true
                "2"-> radio_btn_q2_2.isChecked = true
                "3"-> radio_btn_q2_3.isChecked = true
                "4"-> radio_btn_q2_4.isChecked = true
            }
        }

        navController = Navigation.findNavController(view)

        btn_next_q2.setOnClickListener {
            navController.navigate(R.id.action_question2_to_question3)
        }

        btn_prev_q2.setOnClickListener{
            navController.navigate(R.id.action_question2_to_quesition1)
        }

        radio_group_q2.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.radio_btn_q2_1 ->
                    viewModel.updateValue(2,"1")
                R.id.radio_btn_q2_2 ->
                    viewModel.updateValue(2,"2")
                R.id.radio_btn_q2_3 ->
                    viewModel.updateValue(2,"3")
                R.id.radio_btn_q2_4 ->
                    viewModel.updateValue(2,"4")
            }
        }

    }

}