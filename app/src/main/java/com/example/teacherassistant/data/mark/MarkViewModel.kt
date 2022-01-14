package com.example.teacherassistant.data.mark

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.teacherassistant.data.TeacherDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MarkViewModel(application: Application, subjectId:Int, studentId:Int) : AndroidViewModel(application) {
    private val markDao: MarkDao = TeacherDatabase.getInstance(application).markDao

    val marks: LiveData<List<Mark>> = markDao.getAllByStudentAndSubject(studentId,subjectId)

    fun createMark(mark: Mark) {
        viewModelScope.launch(Dispatchers.IO) {
            markDao.create(mark)
        }
    }
    fun deleteMark(mark: Mark) {
        viewModelScope.launch(Dispatchers.IO) {
            markDao.delete(mark)
        }
    }
}