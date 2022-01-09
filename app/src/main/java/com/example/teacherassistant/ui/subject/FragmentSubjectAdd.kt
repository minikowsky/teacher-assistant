package com.example.teacherassistant.ui.subject

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
import com.example.teacherassistant.data.subject.Subject
import com.example.teacherassistant.data.subject.SubjectViewModel
import java.lang.NumberFormatException

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentSubjectAdd.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentSubjectAdd : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var viewModel: SubjectViewModel
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
        viewModel = ViewModelProvider(requireActivity())[SubjectViewModel::class.java]
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_subject_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_add_subject).apply {
            setOnClickListener {
                val name = view.findViewById<EditText>(R.id.subject_add_name).text.toString()
                val dayOfWeek = view.findViewById<EditText>(R.id.subject_add_dayOfWeek)
                    .text.toString()
                val time = view.findViewById<EditText>(R.id.subject_add_time).text.toString()
                val classromNumber:Int? = try{
                    view.findViewById<EditText>(R.id.subject_add_classroomNumber)
                        .text.toString().toInt()
                } catch(e: NumberFormatException) {null}
                val subject = Subject(0,name,dayOfWeek,time,classromNumber?:0)
                viewModel.createSubject(subject)
            }
        }

        view.findViewById<Button>(R.id.button_subject_display_list).apply {
            setOnClickListener {
                it.findNavController()
                    .navigate(R.id.action_fragmentSubjectAdd_to_fragment_subject_list)
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
         * @return A new instance of fragment FragmentSubjectAdd.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentSubjectAdd().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}