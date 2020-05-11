package com.danmin.sopt_3.network

import com.danmin.sopt_3.data.RequestLogin
import com.danmin.sopt_3.data.ResponseLogin
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RequestInterface{
    @POST("/user/signin")
    fun requestLogin(@Body body: RequestLogin): Call<ResponseLogin>
}