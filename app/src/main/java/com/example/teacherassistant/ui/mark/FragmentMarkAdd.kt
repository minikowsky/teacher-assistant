package com.example.teacherassistant.ui.mark

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.teacherassistant.R
import com.example.teacherassistant.data.mark.Mark
import com.example.teacherassistant.data.mark.MarkViewModel
import java.lang.NumberFormatException

class FragmentMarkAdd : Fragment() {
    private lateinit var viewModel: MarkViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity())[MarkViewModel::class.java]
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mark_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_add_mark).apply {
            setOnClickListener {
                val studentId: Int = 0
                val subjectId: Int = 0
                val markValue: Float?  = try {
                    view.findViewById<EditText>(R.id.mark_add_mark).text.toString().toFloat()
                } catch (e : NumberFormatException) {null}
                val comment = view.findViewById<EditText>(R.id.mark_add_comment).text.toString()
                val mark = Mark(0, studentId, subjectId,markValue?:0F,comment)
                viewModel.createMark(mark)
            }
        }

    }
}