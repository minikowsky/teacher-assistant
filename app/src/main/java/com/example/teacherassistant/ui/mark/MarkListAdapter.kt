package com.example.teacherassistant.ui.mark

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherassistant.R
import com.example.teacherassistant.data.mark.Mark

class MarkListAdapter(val marks: List<Mark>): RecyclerView.Adapter<MarkListAdapter.Holder>() {
    inner class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val markTextView: TextView
        val commentTextView: TextView
        val dateTextView: TextView

        init {
            markTextView = itemView.findViewById<TextView>(R.id.textView_mark)
            commentTextView = itemView.findViewById<TextView>(R.id.textView_comment)
            dateTextView = itemView.findViewById<TextView>(R.id.textView_mark_date)
            itemView.setOnClickListener{

                Toast.makeText(itemView.context,"Działa", Toast.LENGTH_LONG).show()

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.record_mark,parent,false) as View
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.markTextView.text = marks[position].mark.toString()
        holder.commentTextView.text = marks[position].comment
        holder.dateTextView.text = marks[position].date
    }

    override fun getItemCount() = marks.count()

}