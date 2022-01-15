package com.example.teacherassistant.ui.subject

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherassistant.R
import com.example.teacherassistant.data.subject.Subject

class SubjectListAdapter(val subjects: LiveData<List<Subject>>,
                         private val onItemClicked: (Subject) -> Unit)
    : RecyclerView.Adapter<SubjectListAdapter.Holder>() {
    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val nameTextView: TextView = itemView.findViewById(R.id.textView_subject_name)
        val dayOfWeekTextView: TextView = itemView.findViewById(R.id.textView_day_of_week)
        val timeTextView: TextView = itemView.findViewById(R.id.textView_time)
        val classroomNumberTextView: TextView = itemView.findViewById(R.id.textView_classroom)

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
        holder.itemView.setOnClickListener {
            Log.println(Log.INFO,"INFO",subjects.value?.get(position)!!.name)
            onItemClicked(subjects.value?.get(position)!!)

        }
    }

    override fun getItemCount() = subjects.value?.size?:0
}