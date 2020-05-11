package com.danmin.sopt_3.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RequestLoginToServer {
    var retrofit = Retrofit.Builder()
        .baseUrl("http://13.209.144.115:3333")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var service: RequestLoginInterface = retrofit.create(RequestLoginInterface::class.java)
}