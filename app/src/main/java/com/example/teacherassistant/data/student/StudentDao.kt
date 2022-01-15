package com.example.teacherassistant.data.student

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun create(student: Student): Long

    @Query("SELECT * FROM students ORDER BY studentId DESC")
    fun getAll(): LiveData<List<Student>>

    @Delete
    fun delete(student: Student)
}