package com.example.teacherassistant.ui.mark

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.Factory
import java.lang.IllegalArgumentException

class MarkViewModelFactory(private val application: Application,
                           private val subjectId: Long,
                           private val studentId: Long): Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        Log.println(Log.INFO,"markViewModelFacotry","create()")
        if(modelClass.isAssignableFrom(MarkViewModel::class.java)) {
            return MarkViewModel(application,subjectId,studentId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}