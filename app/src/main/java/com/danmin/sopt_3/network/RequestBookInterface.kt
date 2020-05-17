package com.danmin.sopt_3.network

import com.danmin.sopt_3.data.ResponseBook
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

const val key: String = "766b39c61882bd012eae6b547da7de7d"

interface RequestBookInterface {
    @Headers("Authorization: KakaoAK ${key}")
    @GET("/v3/search/book?target=title")
    fun requestBook(@Query("query") title: String): Call<ResponseBook>
}