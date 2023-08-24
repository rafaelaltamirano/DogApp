package com.example.dogapp.domain

data class ResponseWrapper<T>(
    val message: T,
    val status: String
)