package com.example.teacherassistant.ui.student

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherassistant.R
import com.example.teacherassistant.data.student.Student

class StudentListAdapter(val students: List<Student>): RecyclerView.Adapter<StudentListAdapter.Holder>() {
    inner class Holder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val firstNameTextView: TextView
        val lastNameTextView: TextView
        val yearGroupTextView: TextView

        init {
            firstNameTextView = itemView.findViewById(R.id.textView_first_name)
            lastNameTextView = itemView.findViewById(R.id.textView_last_name)
            yearGroupTextView = itemView.findViewById(R.id.textView_year_group)

            itemView.setOnClickListener {
                Toast.makeText(itemView.context,"Działa", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.record_student,parent,false) as View
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.firstNameTextView.text = students[position].firstName
        holder.lastNameTextView.text = students[position].lastName
        holder.yearGroupTextView.text = students[position].yearGroup.toString()
    }

    override fun getItemCount() = students.count()
}