package com.danmin.sopt_3.bookRecycler

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.danmin.sopt_3.R
import com.danmin.sopt_3.data.ResponseBookData

class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val title = itemView.findViewById<TextView>(R.id.title)
    val thumbnail = itemView.findViewById<ImageView>(R.id.thumbnail)
    val contents = itemView.findViewById<TextView>(R.id.contents)
    val authors = itemView.findViewById<TextView>(R.id.authors)

    fun bind(responseBookData: ResponseBookData) {
        title.text = responseBookData.title
        Glide.with(itemView).load(responseBookData.thumbnail).into(thumbnail)
        contents.text = responseBookData.contents
        authors.text = responseBookData.authors.toString()
    }
}
