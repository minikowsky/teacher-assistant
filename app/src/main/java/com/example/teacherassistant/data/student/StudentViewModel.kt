package com.example.teacherassistant.data.student

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.teacherassistant.data.TeacherDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StudentViewModel(application: Application) : AndroidViewModel(application) {

    private val studentDao: StudentDao =  TeacherDatabase.getInstance(application).studentDao
    val students: LiveData<List<Student>> = studentDao.getAll()

    fun deleteStudent(student: Student) {
        viewModelScope.launch(Dispatchers.IO) {
            studentDao.delete(student)
        }
    }

    fun createStudent(student: Student) {
        viewModelScope.launch(Dispatchers.IO) {
            studentDao.create(student)
        }
    }

}