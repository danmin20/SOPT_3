package com.danmin.sopt_3.bookRecycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.danmin.sopt_3.R
import com.danmin.sopt_3.data.ResponseBook

class BookAdapter(private val context: Context) : RecyclerView.Adapter<BookViewHolder>() {

    var datas = mutableListOf<ResponseBook>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_book, parent, false)
        return BookViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(datas[position])
    }
}