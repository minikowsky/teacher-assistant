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

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentStudentAdd.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentStudentAdd : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var viewModel: StudentViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

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
                val yearGroup: Int? = try{
                    view.findViewById<EditText>(R.id.student_year_group).text.toString().toInt()
                } catch(e: NumberFormatException) {null}
                val student = Student(0,firstName,lastName,yearGroup?:0)
                viewModel.createStudent(student)
            }
        }

        view.findViewById<Button>(R.id.button_student_display_list).apply {
            setOnClickListener {
                it.findNavController()
                    .navigate(R.id.action_fragmentStudentAdd_to_fragment_student_list)
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentStudentAdd.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentStudentAdd().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}