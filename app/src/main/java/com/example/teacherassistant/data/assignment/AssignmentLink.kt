package com.example.teacherassistant.data.assignment

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import com.example.teacherassistant.data.student.Student
import com.example.teacherassistant.data.subject.Subject

@Entity(tableName = "assignments",
        primaryKeys = ["studentId","subjectId"],
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
data class AssignmentLink(
    val studentId: Int,
    @ColumnInfo(index = true)
    val subjectId: Int
)
