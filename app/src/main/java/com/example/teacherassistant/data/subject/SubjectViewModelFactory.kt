package com.example.teacherassistant.data.subject

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class SubjectViewModelFactory(private val application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SubjectViewModel::class.java)) {
            return SubjectViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}