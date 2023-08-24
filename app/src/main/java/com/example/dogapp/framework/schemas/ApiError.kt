package com.example.dogapp.framework.schemas

import com.example.dogapp.domain.Response

data class ApiError(
    val status: String,
    val message: String,
    val code: Int,
) : Response<String> {

    override fun toEntity() = message

}
