package com.example.teacherassistant.data.subject

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SubjectDao {
    @Query("SELECT * FROM subjects ORDER BY id DESC")
    fun getAll(): LiveData<List<Subject>>

    @Query("SELECT * FROM subjects WHERE name IN (SELECT )")


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun create(subject: Subject)

    @Delete
    fun delete(subject: Subject)
}