package com.example.teacherassistant.data.subject

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SubjectDao {
    @Query("SELECT * FROM subjects ORDER BY subjectId DESC")
    fun getAll(): LiveData<List<Subject>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun create(subject: Subject)

    @Delete
    fun delete(subject: Subject)
}