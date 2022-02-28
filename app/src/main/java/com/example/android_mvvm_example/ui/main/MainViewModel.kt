package com.example.android_mvvm_example.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    companion object {
        private const val USD_TO_EU_RATE = 0.74f
    }

    val dollarValue = MutableLiveData<String>()

    private val _result = MutableLiveData<Float>()
    val result: LiveData<Float> = _result

    fun convertValue() {
        dollarValue.let {
            if (!it.value.equals("")) {
                _result.value = it.value?.toFloat()?.times(USD_TO_EU_RATE)
            } else {
                _result.value = 0f
            }
        }
    }

}