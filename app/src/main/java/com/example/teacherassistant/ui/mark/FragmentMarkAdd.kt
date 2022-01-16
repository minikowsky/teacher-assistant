package com.example.teacherassistant.ui.mark

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.teacherassistant.MainActivity
import com.example.teacherassistant.R
import com.example.teacherassistant.data.mark.Mark
import com.example.teacherassistant.tools.LanguageManager
import com.google.android.material.textfield.TextInputEditText
import java.lang.NumberFormatException

class FragmentMarkAdd : Fragment() {
    //private lateinit var viewModel: MarkViewModel
    private val navigationArgs: FragmentMarkAddArgs by navArgs()
    val viewModel: MarkViewModel by viewModels { MarkViewModelFactory(
        (requireNotNull(this.activity).application),
        navigationArgs.subjectId,
        navigationArgs.studentId)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //viewModel = ViewModelProvider(requireActivity())[MarkViewModel::class.java]
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mark_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setLanguage(view)

        val spinner = view.findViewById<Spinner>(R.id.mark_add_mark)
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.mark_value,
            R.layout.item_mark_value
        ).also { arrayAdapter ->
            arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
            spinner.adapter = arrayAdapter
        }

        view.findViewById<Button>(R.id.button_add_mark).apply {
            setOnClickListener {
                val markValue: Float? = try{view.findViewById<Spinner>(R.id.mark_add_mark)
                    .selectedItem.toString().toFloat()} catch (e: NumberFormatException){null}
                val comment = view.findViewById<EditText>(R.id.mark_add_comment).text.toString()

                if(markValue!=null && comment.isNotEmpty()){
                    viewModel.createMark(
                        Mark(
                            0,
                            navigationArgs.studentId,
                            navigationArgs.subjectId,
                            markValue,
                            comment)
                    )
                }
            }
        }

    }

    private fun setLanguage(view: View){
        val lang = (activity as MainActivity).lang
        view.findViewById<TextView>(R.id.mark_add_add_grade_text_view).text=
            context?.let { it1 -> LanguageManager.setLanguage(it1,lang,R.string.add_grade) }

        view.findViewById<TextInputEditText>(R.id.mark_add_comment).hint=
            context?.let { it1 -> LanguageManager.setLanguage(it1,lang,R.string.comment) }
        view.findViewById<Button>(R.id.button_add_mark).text=
            context?.let { it1 -> LanguageManager.setLanguage(it1,lang,R.string.add) }
    }
}