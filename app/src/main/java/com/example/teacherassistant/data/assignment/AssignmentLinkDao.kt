package com.example.teacherassistant.data.assignment

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface AssignmentLinkDao {
    @Query("INSERT INTO assignments VALUES (:studentId, :subjectId)")
    suspend fun create(subjectId: Long, studentId: Long)

    @Transaction
    @Query("SELECT * FROM subjects WHERE subjectId = :subjectId")
    fun getAllBySubjectId(subjectId: Long): LiveData<Assignment>

    @Delete
    fun delete(assignmentLink: AssignmentLink)

}