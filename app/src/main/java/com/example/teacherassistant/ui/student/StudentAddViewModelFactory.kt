package com.example.teacherassistant.ui.student

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class StudentAddViewModelFactory(private val application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(StudentAddViewModel::class.java)) {
            return StudentAddViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}