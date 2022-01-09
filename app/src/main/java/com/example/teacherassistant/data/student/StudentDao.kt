package com.example.teacherassistant.data.student

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun create(student: Student)

    @Query("SELECT * FROM students ORDER BY id DESC")
    fun getAll(): LiveData<List<Student>>

    /*@Query("SELECT * FROM students WHERE id =  LIMIT 1")
    fun getById(id: Int)*/

    @Delete
    fun delete(student: Student)
}