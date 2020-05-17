package com.danmin.sopt_3.data

data class ResponseBook(
    val documents: List<ResponseBookData>
)

data class ResponseBookData(
    val title: String,
    val contents: String,
    val authors: ArrayList<String>,
    val thumbnail: String
)
