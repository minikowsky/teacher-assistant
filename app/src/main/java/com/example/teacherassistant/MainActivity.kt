package com.example.teacherassistant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.teacherassistant.fragment.FragmentMarkList
import com.example.teacherassistant.fragment.MarkListAdapter
import com.example.teacherassistant.fragment.student.FragmentStudentList
import com.example.teacherassistant.fragment.student.FragmentSubjectListPerStudent
import com.example.teacherassistant.fragment.student.StudentListAdapter
import com.example.teacherassistant.fragment.subject.FragmentStudentListPerSubject
import com.example.teacherassistant.fragment.subject.FragmentSubjectList
import com.example.teacherassistant.fragment.subject.SubjectListAdapter
import com.example.teacherassistant.model.Mark
import com.example.teacherassistant.model.Student
import com.example.teacherassistant.model.Subject

class MainActivity : AppCompatActivity() {
    val students = mutableListOf<Student>(
        Student("Dominik","Marszałek",3),
        Student("Marta","Marszałek",1)
    )
    val studentAdapter = StudentListAdapter(students)
    val subjects = mutableListOf<Subject>(
        Subject("AMDSA","Monday", "12:30",308),
        Subject("MAV","Wednesday", "15:00",323)
    )
    val subjectAdapter = SubjectListAdapter(subjects)
    val marks = mutableListOf<Mark>(
        Mark(students[0], subjects[0],3.0f,"No cinko no, ledwo","01.02.2021"),
        Mark(students[0], subjects[1],4.0f,"I hope it works","01.02.2021"),
        Mark(students[1], subjects[0],3.5f,"HEHE","01.02.2021"),
        Mark(students[1], subjects[1],5.0f,"No cinko no, ledwo","01.02.2021")
    )
    val markAdapter = MarkListAdapter(marks)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*//loading fragments
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentStudentList, FragmentStudentList())
            .add(R.id.fragmentSubjectList,FragmentSubjectList())
            .add(R.id.fragmentStudentListPerSubject,FragmentStudentListPerSubject())
            .add(R.id.fragmentSubjectListPerStudent, FragmentSubjectListPerStudent())
            .add(R.id.fragmentMarkList,FragmentMarkList())
            .commit()*/
    }
}