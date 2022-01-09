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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherassistant.MainActivity
import com.example.teacherassistant.R
import com.example.teacherassistant.data.mark.MarkViewModel
import com.example.teacherassistant.data.mark.MarkViewModelFactory
import com.google.android.material.floatingactionbutton.FloatingActionButton

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentMarkList.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentMarkList : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var viewModel: MarkViewModel
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
        return inflater.inflate(R.layout.fragment_mark_list, container, false)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val factory = MarkViewModelFactory((requireNotNull(this.activity).application))
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

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentMarkList.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentMarkList().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}