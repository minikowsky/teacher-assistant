package com.example.teacherassistant.ui.student

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherassistant.MainActivity
import com.example.teacherassistant.R
import com.example.teacherassistant.tools.LanguageManager

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
        setLanguage(view)
        //Log.println(Log.INFO,"student list","Student list onViewCreated()")
        view.findViewById<TextView>(R.id.student_list_info_textView).text = "Studenci ${navigationArgs.subjectName}"


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

    private fun setLanguage(view: View){
        val lang = (activity as MainActivity).lang
        view.findViewById<TextView>(R.id.student_list_first_name_text_view).text=
            context?.let { it1 -> LanguageManager.setLanguage(it1,lang,R.string.first_name) }
        view.findViewById<TextView>(R.id.student_list_last_name_text_view).text=
            context?.let { it1 -> LanguageManager.setLanguage(it1,lang,R.string.last_name) }
        view.findViewById<TextView>(R.id.student_list_album_id_text_view).text=
            context?.let { it1 -> LanguageManager.setLanguage(it1,lang,R.string.album_id) }
    }

}