package com.example.teacherassistant.ui.subject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherassistant.R
import com.example.teacherassistant.data.subject.Subject
import com.example.teacherassistant.data.subject.SubjectViewModel

class SubjectListAdapter(val subjects: LiveData<List<Subject>>, private val viewModel: SubjectViewModel)
    : RecyclerView.Adapter<SubjectListAdapter.Holder>() {
    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val nameTextView: TextView = itemView.findViewById(R.id.textView_subject_name)
        val dayOfWeekTextView: TextView = itemView.findViewById(R.id.textView_day_of_week)
        val timeTextView: TextView = itemView.findViewById(R.id.textView_time)
        val classroomNumberTextView: TextView = itemView.findViewById(R.id.textView_classroom)
        val deleteButton: Button = itemView.findViewById(R.id.button_subject_delete)
        init {
            itemView.setOnClickListener {
                Toast.makeText(itemView.context,"Działa", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.record_subject,parent,false) as View
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.nameTextView.text = subjects.value?.get(position)?.name
        holder.dayOfWeekTextView.text = subjects.value?.get(position)?.dayOfWeek
        holder.timeTextView.text = subjects.value?.get(position)?.time
        holder.classroomNumberTextView.text = subjects.value?.get(position)?.classroomNumber.toString()
        holder.deleteButton.setOnClickListener{
            subjects.value?.let {
                existingSubjects ->
                viewModel.deleteSubject(existingSubjects[position])
            }
        }
    }

    override fun getItemCount() = subjects.value?.size?:0
}