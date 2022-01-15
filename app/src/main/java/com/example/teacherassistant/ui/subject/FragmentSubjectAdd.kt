package com.example.teacherassistant.ui.subject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.ViewModelProvider
import com.example.teacherassistant.R
import com.example.teacherassistant.data.subject.Subject
import com.google.android.material.textfield.TextInputEditText
import java.lang.NumberFormatException

class FragmentSubjectAdd : Fragment() {
    private lateinit var viewModel: SubjectViewModel
    private val daysPL = listOf("Poniedziałek","Wtorek","Środa","Czwartek","Piątek")
    private val daysEN = listOf("Monday","Tuesday","Wednesday","Thursday","Friday")

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

        //val adapter = ArrayAdapter(requireContext(),R.layout.item_day_of_week,daysPL)
        val spinner = view.findViewById<Spinner>(R.id.subject_add_dayOfWeek)
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.days_pl,
            R.layout.item_day_of_week
        ).also {adapter ->
            adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        view.findViewById<Button>(R.id.button_add_subject).apply {
            setOnClickListener {
                val name = view.findViewById<TextInputEditText>(R.id.subject_add_name).text.toString()
                val dayOfWeek = view.findViewById<Spinner>(R.id.subject_add_dayOfWeek).selectedItem.toString()
                val time = "${view.findViewById<TimePicker>(R.id.subject_add_time).hour}:" +
                        "${view.findViewById<TimePicker>(R.id.subject_add_time).minute}"
                val classroomNumber:Int? = try{
                    view.findViewById<TextInputEditText>(R.id.subject_add_classroomNumber)
                        .text.toString().toInt()
                } catch(e: NumberFormatException) {null}
                if(isDataValid(name,dayOfWeek,time,classroomNumber)){
                    viewModel.createSubject(Subject(0,name,dayOfWeek,time,classroomNumber?:0))
                } else {
                    Toast.makeText(context,"Invalid data!",Toast.LENGTH_LONG).show()
                }

            }
        }

    }
    private fun isDataValid(name: String, dayOfWeek:String, time:String, classroomNumber:Int?): Boolean{
        if(name.isEmpty()||dayOfWeek.isEmpty()||time.isEmpty()||classroomNumber==null){
            return false
        }
        return true
    }

}