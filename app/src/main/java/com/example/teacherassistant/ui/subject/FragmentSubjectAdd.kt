package com.example.teacherassistant.ui.subject

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
import com.example.teacherassistant.data.subject.Subject
import com.example.teacherassistant.data.subject.SubjectViewModel
import java.lang.NumberFormatException

class FragmentSubjectAdd : Fragment() {

    private lateinit var viewModel: SubjectViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity())[SubjectViewModel::class.java]
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_subject_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_add_subject).apply {
            setOnClickListener {
                val name = view.findViewById<EditText>(R.id.subject_add_name).text.toString()
                val dayOfWeek = view.findViewById<EditText>(R.id.subject_add_dayOfWeek)
                    .text.toString()
                val time = view.findViewById<EditText>(R.id.subject_add_time).text.toString()
                val classroomNumber:Int? = try{
                    view.findViewById<EditText>(R.id.subject_add_classroomNumber)
                        .text.toString().toInt()
                } catch(e: NumberFormatException) {null}
                val subject = Subject(0,name,dayOfWeek,time,classroomNumber?:0)
                viewModel.createSubject(subject)
            }
        }

    }

}