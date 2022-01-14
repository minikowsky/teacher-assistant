package com.example.teacherassistant.ui

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.teacherassistant.R
import com.example.teacherassistant.data.TeacherDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FragmentSettings : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_change_lang).setOnClickListener {
            //TODO: change language
        }

        view.findViewById<Button>(R.id.button_remove_data).setOnClickListener{
            val builder = AlertDialog.Builder(activity).apply {
                setTitle("Are you sure?")
                setMessage("Do you want to remove all data from local database?")
                setPositiveButton("Yes"){
                    dialog, id->
                    GlobalScope.launch {
                        activity?.let { it1 -> TeacherDatabase.getInstance(it1.application).clearAllTables() }
                    }
                    dialog.cancel()
                    activity?.viewModelStore?.clear()
                }
                setNegativeButton("No") {dialog,id ->
                    dialog.cancel()
                }
            }
            builder.create().show()
        }
    }
}