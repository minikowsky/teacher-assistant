package com.example.teacherassistant.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.teacherassistant.data.student.Student
import javax.security.auth.Subject

class StateViewModel(application: Application): AndroidViewModel(application) {
    val currentStudent: LiveData<Student>? = null
    val currentSubject: LiveData<Subject>? = null
    val lastFragment: LiveData<String>? = null
}