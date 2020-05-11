package com.danmin.sopt_3.bookRecycler

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.danmin.sopt_3.R

class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val book_title = itemView.findViewById<TextView>(R.id.book_title)
    val book_img = itemView.findViewById<ImageView>(R.id.book_img)

    fun bind(bookData: BookData) {
        book_title.text = bookData.title
        Glide.with(itemView).load(bookData.book_img).into(book_img)
    }
}
