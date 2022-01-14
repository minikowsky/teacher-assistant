package com.example.teacherassistant.data.mark

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.Factory
import java.lang.IllegalArgumentException

class MarkViewModelFactory(private val application: Application,
                           private val subjectId: Int,
                           private val studentId: Int): Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MarkViewModel::class.java)) {
            return MarkViewModel(application,subjectId,studentId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}