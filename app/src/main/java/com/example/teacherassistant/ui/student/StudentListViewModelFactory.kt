package com.example.teacherassistant.ui.student

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class StudentListViewModelFactory(private val application: Application, val subjectId: Long)
    : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(StudentListViewModel::class.java)) {
            Log.println(Log.WARN,null,subjectId.toString())
            return StudentListViewModel(application, subjectId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}