package com.danmin.sopt_3.network

import com.danmin.sopt_3.data.ResponseBook
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface RequestBookInterface {
    @GET("/v3/search/book?target=title")
    fun requestBook(@Query("query") title: String, @Header("Authorization") auth: String): Call<ResponseBook>
}