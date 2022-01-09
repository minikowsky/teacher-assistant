package com.example.teacherassistant.data

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class StateViewModelFactory(private val application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(StateViewModel::class.java)) {
            return StateViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}