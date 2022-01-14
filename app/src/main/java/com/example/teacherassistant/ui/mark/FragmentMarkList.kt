package com.example.teacherassistant.ui.mark

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherassistant.R
import com.example.teacherassistant.data.mark.MarkViewModel
import com.example.teacherassistant.data.mark.MarkViewModelFactory
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FragmentMarkList : Fragment() {
    lateinit var viewModel: MarkViewModel
    private val navigationArgs: FragmentMarkListArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mark_list, container, false)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val factory = MarkViewModelFactory(
            (requireNotNull(this.activity).application),
            navigationArgs.subjectId,navigationArgs.studentId)
        viewModel = ViewModelProvider(requireActivity(),factory)[MarkViewModel::class.java]

        val markAdapter = MarkListAdapter(viewModel.marks, viewModel)
        viewModel.marks.observe(viewLifecycleOwner,
            Observer {
                markAdapter.notifyDataSetChanged()
            })

        val markListLayoutManager = LinearLayoutManager(context)
        view.findViewById<RecyclerView>(R.id.rv_mark_list)
            .let {
                it.adapter = markAdapter
                it.layoutManager = markListLayoutManager
            }

        view.findViewById<FloatingActionButton>(R.id.fab_add_mark).setOnClickListener {
            it.findNavController().navigate(R.id.action_fragment_mark_list_to_fragmentMarkAdd)
        }
    }

}