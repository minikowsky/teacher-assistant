package com.example.teacherassistant.data.student

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "students")
data class Student(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "studentId")
    val studentId: Long,
    val firstName: String,
    val lastName: String,
    val albumId: Int)
