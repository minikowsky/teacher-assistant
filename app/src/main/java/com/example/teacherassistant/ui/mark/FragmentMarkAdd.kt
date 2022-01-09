package com.example.teacherassistant.ui.mark

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.teacherassistant.R
import com.example.teacherassistant.data.mark.Mark
import com.example.teacherassistant.data.mark.MarkViewModel
import java.lang.NumberFormatException

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentMarkAdd.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentMarkAdd : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var viewModel: MarkViewModel

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
                val date = view.findViewById<EditText>(R.id.mark_add_date).text.toString()
                val mark = Mark(0, studentId, subjectId,markValue?:0F,comment,date)
                viewModel.createMark(mark)
            }
        }

        view.findViewById<Button>(R.id.button_mark_display_list).apply {
            setOnClickListener {
                it.findNavController().navigate(R.id.action_fragmentMarkAdd_to_fragment_mark_list)
            }
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentMarkAdd.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentMarkAdd().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}