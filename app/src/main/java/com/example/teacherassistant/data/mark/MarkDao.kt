package com.example.teacherassistant.data.mark

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MarkDao {

    @Query("SELECT * FROM marks WHERE studentId = :studentId AND subjectId = :subjectId")
    fun getAllByStudentAndSubject(studentId: Long, subjectId: Long): LiveData<List<Mark>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun create(mark: Mark)

    @Delete
    fun delete(mark: Mark)
}