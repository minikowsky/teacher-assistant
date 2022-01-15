package com.example.teacherassistant.data.mark

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.teacherassistant.data.student.Student
import com.example.teacherassistant.data.subject.Subject

@Entity(tableName = "marks",
        foreignKeys = [
            ForeignKey(
                entity = Student::class,
                parentColumns = arrayOf("studentId"),
                childColumns = arrayOf("studentId")),
            ForeignKey(
                entity = Subject::class,
                parentColumns = arrayOf("subjectId"),
                childColumns = arrayOf("subjectId"))
        ])
data class Mark (
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "studentId")
    val studentId: Long,
    @ColumnInfo(name = "subjectId")
    val subjectId: Long,
    val mark:Float,
    val comment: String)