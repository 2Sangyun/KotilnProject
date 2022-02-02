package com.example.kotilnproject

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.quesition1_fragment.*
import kotlinx.android.synthetic.main.question2_fragment.*

class Question2 : Fragment() {

    companion object {
        fun newInstance() = Question2()
    }

    private lateinit var viewModel: Question2ViewModel
    lateinit var navController : NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.question2_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        btn_next_q2.setOnClickListener {
            navController.navigate(R.id.action_question2_to_question3)
        }

        btn_prev_q2.setOnClickListener{
            navController.navigate(R.id.action_question2_to_quesition1)
        }

    }

}