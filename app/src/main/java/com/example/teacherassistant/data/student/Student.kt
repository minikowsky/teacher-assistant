package com.example.teacherassistant.data.student

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "students")
data class Student(
    @PrimaryKey(autoGenerate = true)
    val studentId: Int,
    val firstName: String,
    val lastName: String,
    val albumId: Int)
