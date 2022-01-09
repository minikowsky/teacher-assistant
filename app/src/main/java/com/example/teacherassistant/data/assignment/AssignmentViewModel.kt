package com.example.teacherassistant.data.assignment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.teacherassistant.data.TeacherDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AssignmentViewModel(application: Application): AndroidViewModel(application){
    private val assignmentDao: AssignmentDao = TeacherDatabase.getInstance(application).assignmentDao
    fun createAssignment(assignment: Assignment){
        viewModelScope.launch(Dispatchers.IO) {
            assignmentDao.create(assignment)
        }
    }
    fun deleteAssignment(assignment: Assignment){
        viewModelScope.launch(Dispatchers.IO) {
            assignmentDao.delete(assignment)
        }
    }
}