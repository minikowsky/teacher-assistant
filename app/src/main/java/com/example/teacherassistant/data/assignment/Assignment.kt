package com.example.teacherassistant.data.assignment

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "assignments")
data class Assignment(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val studentId: Int,
    val subjectId: Int
)
