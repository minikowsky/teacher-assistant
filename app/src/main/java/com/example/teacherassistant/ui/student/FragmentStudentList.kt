package com.example.teacherassistant.ui.student

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherassistant.R

class FragmentStudentList : Fragment() {
    lateinit var viewModel: StudentListViewModel
    private val navigationArgs: FragmentStudentListArgs by navArgs()

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

        view.findViewById<TextView>(R.id.student_list_info_textView).text = navigationArgs.subjectName

        val factory = StudentListViewModelFactory(
            (requireNotNull(this.activity).application),
            navigationArgs.subjectId)
        viewModel= ViewModelProvider(requireActivity(),factory)[StudentListViewModel::class.java]

        val studentAdapter = StudentListAdapter(viewModel.studentsBySubjectId){
            val action = FragmentStudentListDirections.actionFragmentStudentListToFragmentMarkList(
                navigationArgs.subjectId,
                navigationArgs.subjectName,
                it.studentId,
                "${it.firstName} ${it.lastName}")
            findNavController().navigate(action)
        }

        viewModel.studentsBySubjectId.observe(viewLifecycleOwner,
            Observer {
                studentAdapter.notifyDataSetChanged()
            })

        val studentListLayoutManager = LinearLayoutManager(context)
        view.findViewById<RecyclerView>(R.id.rv_student_list)
            .let {
                it.adapter = studentAdapter
                it.layoutManager = studentListLayoutManager
            }

    }
}