package com.example.teacherassistant.data.assignment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.teacherassistant.data.TeacherDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AssignmentViewModel(application: Application, subjectId: Int): AndroidViewModel(application){
    private val assignmentLinkDao: AssignmentLinkDao = TeacherDatabase.getInstance(application).assignmentLinkDao

    val studentsBySubjectId: LiveData<Assignment> = assignmentLinkDao.getAllBySubjectId(subjectId)

    fun createAssignment(subejctId:Int, studentId: Int){
        viewModelScope.launch(Dispatchers.IO) {
            assignmentLinkDao.create(subejctId, studentId)
        }
    }
}