package com.example.dogapp.domain.exception

data class HttpException(
    val code: Int,
    override val message: String? = null,
) : Exception(message)

