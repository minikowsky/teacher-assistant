package com.example.teacherassistant.ui.student

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherassistant.MainActivity
import com.example.teacherassistant.R
import com.example.teacherassistant.data.student.StudentViewModel
import com.example.teacherassistant.data.student.StudentViewModelFactory
import com.google.android.material.floatingactionbutton.FloatingActionButton

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
/**
 * A simple [Fragment] subclass.
 * Use the [FragmentStudentList.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentStudentList : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var viewModel: StudentViewModel

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_list, container, false)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val factory = StudentViewModelFactory((requireNotNull(this.activity).application))
        viewModel= ViewModelProvider(requireActivity(),factory)[StudentViewModel::class.java]
        val studentAdapter = StudentListAdapter(viewModel.students,viewModel)

        viewModel.students.observe(viewLifecycleOwner,
            Observer {
                studentAdapter.notifyDataSetChanged()
            })

        val studentListLayoutManager = LinearLayoutManager(context)
        view.findViewById<RecyclerView>(R.id.rv_student_list)
            .let {
                it.adapter = studentAdapter
                it.layoutManager = studentListLayoutManager
            }

        view.findViewById<FloatingActionButton>(R.id.fab_add_student).setOnClickListener {
            it.findNavController().navigate(R.id.action_fragment_student_list_to_fragmentStudentAdd)
        }

        view.findViewById<Button>(R.id.buttonSubjects).setOnClickListener{
            it.findNavController().navigate(R.id.action_fragment_student_list_to_fragment_subject_list)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentStudentList.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentStudentList().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}