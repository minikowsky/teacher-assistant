package com.example.teacherassistant.ui.student

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.teacherassistant.data.TeacherDatabase
import com.example.teacherassistant.data.assignment.Assignment
import com.example.teacherassistant.data.assignment.AssignmentLinkDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StudentListViewModel(application: Application, subjectId: Int): AndroidViewModel(application){
    private val assignmentLinkDao: AssignmentLinkDao = TeacherDatabase.getInstance(application).assignmentLinkDao

    val studentsBySubjectId: LiveData<Assignment> = assignmentLinkDao.getAllBySubjectId(subjectId)

    fun createAssignment(subejctId:Int, studentId: Int){
        viewModelScope.launch(Dispatchers.IO) {
            assignmentLinkDao.create(subejctId, studentId)
        }
    }
}