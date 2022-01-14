package com.example.teacherassistant.ui.subject

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.teacherassistant.data.TeacherDatabase
import com.example.teacherassistant.data.subject.Subject
import com.example.teacherassistant.data.subject.SubjectDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SubjectViewModel(application: Application) : AndroidViewModel(application) {
    private val subjectDao: SubjectDao = TeacherDatabase.getInstance(application).subjectDao
    val subjects: LiveData<List<Subject>> = subjectDao.getAll()

    fun createSubject(subject: Subject) {
        viewModelScope.launch(Dispatchers.IO) {
            subjectDao.create(subject)
        }
    }

    fun deleteSubject(subject: Subject) {
        viewModelScope.launch(Dispatchers.IO) {
            subjectDao.delete(subject)
        }
    }
}