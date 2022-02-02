package com.example.kotilnproject

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.activity_start_solve.*
import kotlinx.android.synthetic.main.quesition1_fragment.*

class Quesition1 : Fragment() {

    private lateinit var viewModel: Quesition1ViewModel
    lateinit var navController : NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.quesition1_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        btn_next_q1.setOnClickListener {
            navController.navigate(R.id.action_quesition1_to_question2)
        }

    }

}