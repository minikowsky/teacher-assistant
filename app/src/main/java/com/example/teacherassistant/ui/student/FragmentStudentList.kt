package com.example.teacherassistant.ui.student

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherassistant.R

class FragmentStudentList : Fragment() {

    private val navigationArgs: FragmentStudentListArgs by navArgs()
    val viewModel : StudentListViewModel by viewModels { StudentListViewModelFactory(
        (requireNotNull(this.activity).application),
        navigationArgs.subjectId) }

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
        Log.println(Log.INFO,"student list","Student list onViewCreated()")
        view.findViewById<TextView>(R.id.student_list_info_textView).text = navigationArgs.subjectName

        viewModel.studentsBySubjectId.value?.students?.forEach { s-> Log.println(Log.INFO,"t",s.firstName+s.lastName) }

        val studentAdapter = StudentListAdapter(viewModel.studentsBySubjectId){
            val action = FragmentStudentListDirections.actionFragmentStudentListToFragmentMarkList(
                navigationArgs.subjectId,
                navigationArgs.subjectName,
                it.studentId,
                "${it.firstName} ${it.lastName}")
            findNavController().navigate(action)
        }

        val studentListLayoutManager = LinearLayoutManager(context)
        view.findViewById<RecyclerView>(R.id.rv_student_list)
            .apply {
                adapter = studentAdapter
                layoutManager = studentListLayoutManager
            }

        viewModel.studentsBySubjectId.observe(viewLifecycleOwner,
            Observer {
                studentAdapter.notifyDataSetChanged()
            })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.println(Log.INFO,"student list","Student list onDestroyView()")
    }
}