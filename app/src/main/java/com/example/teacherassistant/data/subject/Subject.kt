package com.example.teacherassistant.data.subject

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "subjects")
data class Subject(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "subjectId")
    val subjectId: Long,
    val name: String,
    val dayOfWeek: String,
    val time: String,
    val classroomNumber: Int)
