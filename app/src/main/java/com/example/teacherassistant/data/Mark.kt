package com.example.teacherassistant.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "marks")
data class Mark (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val studentId: Int,
    val subjectId: Int,
    val mark:Float,
    val comment: String,
    val date: String)