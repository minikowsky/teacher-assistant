package com.example.teacherassistant.ui.subject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherassistant.R
import com.example.teacherassistant.data.Subject

class SubjectListAdapter(val subjects: List<Subject>): RecyclerView.Adapter<SubjectListAdapter.Holder>() {
    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val nameTextView: TextView
        val dayOfWeekTextView: TextView
        val timeTextView: TextView
        val classroomNumberTextView: TextView

        init {
            nameTextView = itemView.findViewById(R.id.textView_subject_name)
            dayOfWeekTextView = itemView.findViewById(R.id.textView_day_of_week)
            timeTextView = itemView.findViewById(R.id.textView_time)
            classroomNumberTextView = itemView.findViewById(R.id.textView_classroom)
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
        holder.nameTextView.text = subjects[position].name
        holder.dayOfWeekTextView.text = subjects[position].dayOfWeek
        holder.timeTextView.text = subjects[position].time
        holder.classroomNumberTextView.text = subjects[position].classroomNumber.toString()
    }

    override fun getItemCount() = subjects.count()
}