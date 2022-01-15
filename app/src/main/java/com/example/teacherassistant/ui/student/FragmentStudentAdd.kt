package com.example.teacherassistant.ui.student

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherassistant.R
import com.example.teacherassistant.data.student.Student
import com.google.android.material.textfield.TextInputEditText
import java.lang.NumberFormatException

class FragmentStudentAdd : Fragment() {

    private lateinit var viewModel: StudentAddViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_add, container, false)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val factory = StudentAddViewModelFactory((requireNotNull(this.activity).application))
        viewModel = ViewModelProvider(requireActivity(),factory)[StudentAddViewModel::class.java]
        val studentAddAdapter = StudentAddAdapter(viewModel.subjects)
        viewModel.subjects.observe(viewLifecycleOwner, Observer {
            studentAddAdapter.notifyDataSetChanged()
        })
        val studentAddLayoutManager = LinearLayoutManager(context)
        view.findViewById<RecyclerView>(R.id.rv_add_student_subjects)
            .let {
                it.adapter = studentAddAdapter
                it.layoutManager = studentAddLayoutManager
            }


        view.findViewById<Button>(R.id.button_add_student).apply {
            setOnClickListener {
                val firstName = view.findViewById<TextInputEditText>(R.id.student_first_name).text.toString()
                val lastName= view.findViewById<TextInputEditText>(R.id.student_last_name).text.toString()
                val studentId: Int? = try{
                    view.findViewById<TextInputEditText>(R.id.student_album_id).text.toString().toInt()
                } catch(e: NumberFormatException) {null}

                val student = Student(0,firstName,lastName,studentId?:0)
                if(isDataValid(firstName,lastName,studentId)){
                    viewModel.createStudent(student, studentAddAdapter.selectedSubjects)
                    //Clear data
                    view.findViewById<TextInputEditText>(R.id.student_first_name).setText("")
                    view.findViewById<TextInputEditText>(R.id.student_last_name).setText("")
                    view.findViewById<TextInputEditText>(R.id.student_album_id).setText("")

                } else {
                    Toast.makeText(context,"Invalid data!",Toast.LENGTH_LONG).show()
                }

            }
        }
    }
    private fun isDataValid(firstName: String, lastName: String, studentId: Int?): Boolean{
        if(firstName.isEmpty()||lastName.isEmpty()||studentId==null){
            return false
        }
        return true
    }
}