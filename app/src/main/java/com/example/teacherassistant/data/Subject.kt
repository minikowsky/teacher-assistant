package com.example.teacherassistant.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "subjects")
data class Subject(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val dayOfWeek: String,
    val time: String,
    val classroomNumber: Number)
