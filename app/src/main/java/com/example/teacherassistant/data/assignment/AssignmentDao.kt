package com.example.teacherassistant.data.assignment

import androidx.room.*

@Dao
interface AssignmentDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun create(assignment: Assignment)

    @Delete
    fun delete(assignment: Assignment)

}