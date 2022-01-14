package com.example.teacherassistant.data.assignment

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.teacherassistant.data.student.Student
import com.example.teacherassistant.data.subject.Subject

data class Assignment (
    @Embedded val subject: Subject,
    @Relation(parentColumn = "subjectId",
              entityColumn = "studentId",
              associateBy = Junction(AssignmentLink::class)
    )
    val students: List<Student>
)