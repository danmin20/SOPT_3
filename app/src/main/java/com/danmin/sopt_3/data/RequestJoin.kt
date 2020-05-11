package com.danmin.sopt_3.data

data class RequestJoin(
    val id: String,
    val password: String,
    val name: String,
    val email: String,
    val phone: String
)