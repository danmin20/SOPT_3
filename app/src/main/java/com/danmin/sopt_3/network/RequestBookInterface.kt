package com.danmin.sopt_3.network

import android.widget.ImageView
import com.danmin.sopt_3.R
import com.danmin.sopt_3.data.RequestBook
import com.danmin.sopt_3.data.ResponseBook
import kotlinx.android.synthetic.main.fragment_library.view.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

const val key: String = "766b39c61882bd012eae6b547da7de7d"

interface RequestBookInterface {
    @Headers("Authorization: ${key}")
    @GET("/v3/search/book")
    fun requestBook(@Query("query") title: String): Call<ResponseBook>
}