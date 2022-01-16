package com.example.teacherassistant.ui

import android.app.AlertDialog
import android.app.Application
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.teacherassistant.MainActivity
import com.example.teacherassistant.R
import com.example.teacherassistant.data.TeacherDatabase
import com.example.teacherassistant.tools.LanguageManager
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class FragmentSettings : Fragment() {

    var alertTitle = "Are you sure?"
    var alertMessage = "Do you want to remove all data from local database?"
    var alertYes = "Yes"
    var alertNo = "No"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setLanguage(view)
        view.findViewById<Button>(R.id.button_change_lang).setOnClickListener {
            if((activity as MainActivity).lang == "en"){
                (activity as MainActivity).lang = "pl"
                alertTitle = "Potwierdzenie"
                alertMessage = "Czy na pewno chcesz usunąć wszystkie dane z bazy lokalnej?"
                alertYes = "Tak"
                alertNo = "Nie"
            } else {
                (activity as MainActivity).lang = "en"
                alertTitle = "Confirmation"
                alertMessage = "Do you want to remove all data from local database?"
                alertYes = "Yes"
                alertNo = "No"
            }
            setLanguage(view)
        }


        view.findViewById<Button>(R.id.button_remove_data).setOnClickListener{
            val builder = AlertDialog.Builder(activity).apply {
                setTitle(alertTitle)
                setMessage(alertMessage)
                setPositiveButton(alertYes){
                        dialog, _ ->
                    GlobalScope.launch {
                        activity?.let { it1 -> TeacherDatabase.getInstance(it1.application).clearAllTables() }
                    }
                    dialog.cancel()
                    activity?.viewModelStore?.clear()
                }
                setNegativeButton(alertNo) { dialog, _ ->
                    dialog.cancel()
                }
            }
            builder.create().show()
        }
    }

    private fun setLanguage(view: View){
        val lang = (activity as MainActivity).lang
        view.findViewById<Button>(R.id.button_change_lang).text=
            context?.let { it1 -> LanguageManager.setLanguage(it1,lang,R.string.settings_change_language_btn_text) }
        view.findViewById<Button>(R.id.button_remove_data).text=
            context?.let { it1 -> LanguageManager.setLanguage(it1,lang,R.string.settings_remove_data_btn_text) }
        view.findViewById<TextView>(R.id.settings_textView_info).text=
            context?.let { it1 -> LanguageManager.setLanguage(it1,lang,R.string.settings) }
    }
}