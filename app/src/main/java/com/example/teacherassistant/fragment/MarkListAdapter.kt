package com.example.teacherassistant.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherassistant.R
import com.example.teacherassistant.model.Mark

class MarkListAdapter(val marks: List<Mark>): RecyclerView.Adapter<MarkListAdapter.Holder>() {
    inner class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val markTextView: TextView
        val commentTextView: TextView
        val dateTextView: TextView

        init {
            markTextView = itemView.findViewById(R.id.textView_mark)
            commentTextView = itemView.findViewById(R.id.textView_comment)
            dateTextView = itemView.findViewById(R.id.textView_mark_date)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.record_mark,parent,false) as View
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.markTextView.text = marks[position].mark.toString()
        holder.commentTextView.text = marks[position].mark.toString()
        holder.dateTextView.text = marks[position].date
    }

    override fun getItemCount() = marks.count()

}