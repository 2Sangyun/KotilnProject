package com.example.kotilnproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//enum class

// 정답 변경 관련 라이브데이터를 갖는다.
class MyAnswers : ViewModel() {
    // Mutable 라이브 데이터 - 수정가능
    // 일반 라이브 데이터 - Read Only

    private val _question1_answer = MutableLiveData<String>()
    private val _question2_answer = MutableLiveData<String>()
    private val _question3_answer = MutableLiveData<String>()

    val question1_answer: LiveData<String>
        get() = _question1_answer

    val question2_answer: LiveData<String>
        get() = _question2_answer

    val question3_answer: LiveData<String>
        get() = _question3_answer

    //초기화
    init{
        _question1_answer.value = "선택안함"
        _question2_answer.value = "선택안함"
        _question3_answer.value = "선택안함"
    }

    fun updateValue(questionNum :Int, yourPick : String){
        when(questionNum){
            1 ->
                _question1_answer.value = yourPick
            2 ->
                _question2_answer.value = yourPick
            3 ->
                _question3_answer.value = yourPick
        }
    }
}