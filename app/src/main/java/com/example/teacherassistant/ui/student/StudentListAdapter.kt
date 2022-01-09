package com.example.teacherassistant.ui.student

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherassistant.R
import com.example.teacherassistant.data.student.Student
import com.example.teacherassistant.data.student.StudentViewModel

class StudentListAdapter(private val students: LiveData<List<Student>>,
                         private val viewModel: StudentViewModel)
    : RecyclerView.Adapter<StudentListAdapter.Holder>() {

    inner class Holder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val firstNameTextView: TextView = itemView.findViewById(R.id.textView_first_name)
        val lastNameTextView: TextView = itemView.findViewById(R.id.textView_last_name)
        val yearGroupTextView: TextView = itemView.findViewById(R.id.textView_year_group)
        val deleteButton: Button = itemView.findViewById(R.id.button_student_delete)
        init {
            itemView.setOnClickListener {
                Toast.makeText(itemView.context,"Działa", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.record_student,parent,false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.firstNameTextView.text = students.value?.get(position)?.firstName
        holder.lastNameTextView.text = students.value?.get(position)?.lastName
        holder.yearGroupTextView.text = students.value?.get(position)?.yearGroup.toString()
        holder.deleteButton.setOnClickListener{
            students.value?.let {
                existingStudents ->
                viewModel.deleteStudent(existingStudents[position])
            }
        }
    }

    override fun getItemCount() = students.value?.size?:0
}