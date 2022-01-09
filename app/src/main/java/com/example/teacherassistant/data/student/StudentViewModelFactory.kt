package com.example.teacherassistant.data.student

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class StudentViewModelFactory(private val application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(StudentViewModel::class.java)) {
            return StudentViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}