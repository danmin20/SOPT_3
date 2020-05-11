package com.danmin.sopt_3.network

import com.danmin.sopt_3.data.RequestJoin
import com.danmin.sopt_3.data.ResponseJoin
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RequestJoinInterface {
    @POST("/user/signup")
    fun requestJoin(@Body body: RequestJoin): Call<ResponseJoin>
}