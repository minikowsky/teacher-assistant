package com.example.teacherassistant.ui.student

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.teacherassistant.data.TeacherDatabase
import com.example.teacherassistant.data.assignment.AssignmentLinkDao
import com.example.teacherassistant.data.student.Student
import com.example.teacherassistant.data.student.StudentDao
import com.example.teacherassistant.data.subject.Subject
import com.example.teacherassistant.data.subject.SubjectDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StudentAddViewModel(application: Application) : AndroidViewModel(application) {

    private val studentDao: StudentDao = TeacherDatabase.getInstance(application).studentDao
    private val subjectDao: SubjectDao =  TeacherDatabase.getInstance(application).subjectDao
    private val assignmentLinkDao: AssignmentLinkDao = TeacherDatabase.getInstance(application).assignmentLinkDao

    val subjects = subjectDao.getAll()

    fun createStudent(student: Student,subjectsToLink:MutableList<Subject?>) {
        viewModelScope.launch(Dispatchers.IO) {
            val studentId = studentDao.create(student)
            subjectsToLink.forEach{
                assignmentLinkDao.create(it?.subjectId!!,studentId)
            }
        }

    }

}