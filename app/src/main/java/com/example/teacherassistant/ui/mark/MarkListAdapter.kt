package com.example.teacherassistant.ui.mark

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherassistant.R
import com.example.teacherassistant.data.mark.Mark
import com.example.teacherassistant.data.mark.MarkViewModel

class MarkListAdapter(
    private val marks: LiveData<List<Mark>>,
    private val viewModel: MarkViewModel)
    : RecyclerView.Adapter<MarkListAdapter.Holder>() {

    inner class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val markTextView: TextView = itemView.findViewById(R.id.textView_mark)
        val commentTextView: TextView = itemView.findViewById(R.id.textView_comment)
        val deleteButton: Button = itemView.findViewById(R.id.button_mark_delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.record_mark,parent,false) as View
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.markTextView.text = marks.value?.get(position)?.mark.toString()
        holder.commentTextView.text = marks.value?.get(position)?.comment

        holder.deleteButton.setOnClickListener{
            marks.value?.let { existingMarks ->
                viewModel.deleteMark(existingMarks[position])
            }
        }
    }

    override fun getItemCount() = marks.value?.size?:0

}