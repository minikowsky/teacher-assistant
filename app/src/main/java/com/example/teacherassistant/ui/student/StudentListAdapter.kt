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
import com.example.teacherassistant.data.assignment.Assignment
import com.example.teacherassistant.data.student.Student
import com.example.teacherassistant.data.student.StudentViewModel
import com.example.teacherassistant.data.subject.Subject

class StudentListAdapter(private val assignments: LiveData<Assignment>,
                         private val onItemClicked: (Student) -> Unit)
    : RecyclerView.Adapter<StudentListAdapter.Holder>() {

    inner class Holder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val firstNameTextView: TextView = itemView.findViewById(R.id.textView_first_name)
        val lastNameTextView: TextView = itemView.findViewById(R.id.textView_last_name)
        val albumIdTextView: TextView = itemView.findViewById(R.id.textView_album_id)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.record_student,parent,false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.firstNameTextView.text = assignments.value?.students?.get(position)?.firstName
        holder.lastNameTextView.text = assignments.value?.students?.get(position)?.lastName
        holder.albumIdTextView.text = assignments.value?.students?.get(position)?.albumId.toString()
        holder.itemView.setOnClickListener {
            onItemClicked(assignments.value?.students?.get(position)!!)
        }
    }

    override fun getItemCount() = assignments.value?.students?.size?:0
}