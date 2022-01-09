package com.example.teacherassistant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.teacherassistant.ui.mark.MarkListAdapter
import com.example.teacherassistant.ui.student.StudentListAdapter
import com.example.teacherassistant.ui.subject.SubjectListAdapter
import com.example.teacherassistant.data.mark.Mark
import com.example.teacherassistant.data.student.Student
import com.example.teacherassistant.data.subject.Subject

class MainActivity : AppCompatActivity() {
    val students = mutableListOf<Student>(
        Student(0,"Dominik","retg",3),
        Student(1,"Marta","vxb",1),
        Student(2, "HEHE","ads",3),
        Student(3, "HASFDASFS","fds",1)
    )
    val studentAdapter = StudentListAdapter(students)
    val subjects = mutableListOf<Subject>(
        Subject(0,"AMDSA","Monday", "12:30",308),
        Subject(1,"MAV","Wednesday", "15:00",323),
        Subject(2,"MAV","Saturday", "15:00",323),
        Subject(3,"MAV","Thursday", "13:00",323)
    )
    val subjectAdapter = SubjectListAdapter(subjects)
    val marks = mutableListOf<Mark>(
        Mark(0,0, 0,3.0f,"No cinko no, ledwo","01.02.2021"),
        Mark(1,3, 2,4.0f,"I hope it works","01.02.2021"),
        Mark(2,2, 1,3.5f,"HEHE","01.02.2021"),
        Mark(3,1, 3,5.0f,"No cinko no, ledwo","01.02.2021")
    )
    val markAdapter = MarkListAdapter(marks)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*findViewById<Button>(R.id.buttonSubjects)
            .setOnClickListener {
                findNavController(R.id.navigation)
                    .navigate(R.id.action_fragment_subject_list_to_fragment_student_list )
            }
        findViewById<Button>(R.id.buttonStudents)
            .setOnClickListener {
                findNavController(R.id.navigation)
                    .navigate(R.id.action_fragment_student_list_to_fragment_subject_list )
            }*/
    }
}