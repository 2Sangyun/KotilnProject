package com.example.kotilnproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//enum class

// 정답 변경 관련 라이브데이터를 갖는다.
class MyAnswers : ViewModel() {
    // Mutable 라이브 데이터 - 수정가능
    // 일반 라이브 데이터 - Read Only

    private val _answer = MutableLiveData<Int>()

    val answer: LiveData<Int>
        get() = _answer

    //초기화
    init{
        _answer.value = 0
    }

    //fun updateValue()
}