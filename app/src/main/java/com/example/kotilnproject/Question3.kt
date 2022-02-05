package com.example.kotilnproject

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.question1_fragment.*
import kotlinx.android.synthetic.main.question3_fragment.*

class Question3 : Fragment() {

    companion object {
        fun newInstance() = Question3()
    }

    private lateinit var viewModel: Question3ViewModel
    lateinit var navController : NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.question3_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        btn_prev_q3.setOnClickListener {
            navController.navigate(R.id.action_question3_to_question2)
        }

    }

}