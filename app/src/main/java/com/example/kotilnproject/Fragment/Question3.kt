package com.example.kotilnproject.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.kotilnproject.LiveData.MyAnswers
import com.example.kotilnproject.R
import kotlinx.android.synthetic.main.question3_fragment.*

class Question3 : Fragment() {
    private val viewModel : MyAnswers by activityViewModels()
    lateinit var navController : NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.question3_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.question3_answer.observe(viewLifecycleOwner, Observer { })

        if (viewModel.question3_answer.value != "선택안함"){
            when(viewModel.question3_answer.value){
                "1"-> radio_btn_q3_1.isChecked = true
                "2"-> radio_btn_q3_2.isChecked = true
                "3"-> radio_btn_q3_3.isChecked = true
                "4"-> radio_btn_q3_4.isChecked = true
            }
        }
        navController = Navigation.findNavController(view)

        btn_prev_q3.setOnClickListener {
            navController.navigate(R.id.action_question3_to_question2)
        }

        radio_group_q3.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.radio_btn_q3_1 ->
                    viewModel.updateValue(3,"1")
                R.id.radio_btn_q3_2 ->
                    viewModel.updateValue(3,"2")
                R.id.radio_btn_q3_3 ->
                    viewModel.updateValue(3,"3")
                R.id.radio_btn_q3_4 ->
                    viewModel.updateValue(3,"4")
            }
        }

    }

}