package com.example.teacherassistant.ui.student

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class StudentListViewModelFactory(private val application: Application, val subjectId: Int): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(StudentListViewModel::class.java)) {
            return StudentListViewModel(application, subjectId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}