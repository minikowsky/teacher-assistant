package com.example.teacherassistant.ui.student

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.teacherassistant.R
import com.example.teacherassistant.data.student.Student
import com.example.teacherassistant.data.student.StudentViewModel
import java.lang.NumberFormatException

class FragmentStudentAdd : Fragment() {

    private lateinit var viewModel: StudentViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity())[StudentViewModel::class.java]

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_add_student).apply {
            setOnClickListener {
                val firstName = view.findViewById<EditText>(R.id.student_first_name).text.toString()
                val lastName= view.findViewById<EditText>(R.id.student_last_name).text.toString()
                val studentId: Int? = try{
                    view.findViewById<EditText>(R.id.student_album_id).text.toString().toInt()
                } catch(e: NumberFormatException) {null}
                val student = Student(0,firstName,lastName,studentId?:0)
                viewModel.createStudent(student)
            }
        }

    }
}