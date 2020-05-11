package com.danmin.sopt_3.feedRecycler

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.danmin.sopt_3.R

class FeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tv_username = itemView.findViewById<TextView>(R.id.tv_username)
    val img_profile = itemView.findViewById<ImageView>(R.id.img_profile)
    val img_contents = itemView.findViewById<ImageView>(R.id.img_contents)

    fun bind(feedData: FeedData) {
        tv_username.text = feedData.userName
        Glide.with(itemView).load(feedData.img_profile).into(img_profile)
        Glide.with(itemView).load(feedData.img_contents).into(img_contents)
    }
}