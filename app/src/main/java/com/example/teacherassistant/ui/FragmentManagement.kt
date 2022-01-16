package com.example.teacherassistant.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.teacherassistant.MainActivity
import com.example.teacherassistant.R
import com.example.teacherassistant.tools.LanguageManager

class FragmentManagement : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_management, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setLanguage(view)
        view.findViewById<Button>(R.id.button_add_student).setOnClickListener{
            findNavController().navigate(R.id.action_fragmentManagement_to_fragment_student_add)
        }

        view.findViewById<Button>(R.id.button_add_subject).setOnClickListener{
            findNavController().navigate(R.id.action_fragmentManagement_to_fragmentSubjectAdd)
        }
    }
    private fun setLanguage(view: View){
        val lang = (activity as MainActivity).lang
        view.findViewById<Button>(R.id.button_add_subject).text=
            context?.let { it1 -> LanguageManager.setLanguage(it1,lang,R.string.management_add_subject_btn_text) }
        view.findViewById<Button>(R.id.button_add_student).text=
            context?.let { it1 -> LanguageManager.setLanguage(it1,lang,R.string.management_add_student_btn_text) }
        view.findViewById<TextView>(R.id.management_textView_info).text=
            context?.let { it1 -> LanguageManager.setLanguage(it1,lang,R.string.management) }
    }
}