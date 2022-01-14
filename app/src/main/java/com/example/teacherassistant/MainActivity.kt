package com.example.teacherassistant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.teacherassistant.ui.mark.MarkListAdapter
import com.example.teacherassistant.ui.student.StudentListAdapter
import com.example.teacherassistant.ui.subject.SubjectListAdapter
import com.example.teacherassistant.data.mark.Mark
import com.example.teacherassistant.data.student.Student
import com.example.teacherassistant.data.subject.Subject
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        bottomNavigationView.setupWithNavController(navHostFragment.navController)

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