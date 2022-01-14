package com.example.teacherassistant.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.teacherassistant.R

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

        view.findViewById<Button>(R.id.button_add_student).setOnClickListener{
            findNavController().navigate(R.id.action_fragmentManagement_to_fragment_student_add)
        }

        view.findViewById<Button>(R.id.button_add_subject).setOnClickListener{
            findNavController().navigate(R.id.action_fragmentManagement_to_fragmentSubjectAdd)
        }
    }
}