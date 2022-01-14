package com.example.teacherassistant.ui.subject

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherassistant.R
import com.example.teacherassistant.data.subject.SubjectViewModel
import com.example.teacherassistant.data.subject.SubjectViewModelFactory

class FragmentSubjectList : Fragment() {
    lateinit var viewModel: SubjectViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_subject_list, container, false)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = SubjectViewModelFactory((requireNotNull(this.activity).application))
        viewModel = ViewModelProvider(requireActivity(),factory)[SubjectViewModel::class.java]
        val subjectAdapter = SubjectListAdapter(viewModel.subjects) {
            val action = FragmentSubjectListDirections
                .actionFragmentSubjectListToFragmentStudentList(it.subjectId,it.name)
            this.findNavController().navigate(action)
        }

        viewModel.subjects.observe(viewLifecycleOwner,
            Observer {
                subjectAdapter.notifyDataSetChanged()
            })

        val subjectListLayoutManager = LinearLayoutManager(context)
        view.findViewById<RecyclerView>(R.id.rv_subject_list)
            .let {
                it.adapter = subjectAdapter
                it.layoutManager = subjectListLayoutManager
            }

    }
}