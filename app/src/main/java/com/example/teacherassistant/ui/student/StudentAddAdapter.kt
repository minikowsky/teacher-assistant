package com.example.teacherassistant.ui.student

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherassistant.R
import com.example.teacherassistant.data.subject.Subject

class StudentAddAdapter(private val subjects: LiveData<List<Subject>>)
    : RecyclerView.Adapter<StudentAddAdapter.Holder>() {
    inner class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val subjectName =  itemView.findViewById<TextView>(R.id.item_subject_name)
        val subjectCheckBox = itemView.findViewById<CheckBox>(R.id.item_subject_checkBox)
    }

    val selectedSubjects: MutableList<Subject?> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
    : Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_subject,parent,false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.subjectName.text = subjects.value?.get(position)?.name
        holder.subjectCheckBox.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                Log.println(Log.INFO,"T",position.toString())
                selectedSubjects.add(subjects.value?.get(position))
            } else {
                selectedSubjects.remove(subjects.value?.get(position))
            }
        }
    }

    override fun getItemCount(): Int = subjects.value?.size?:0
}