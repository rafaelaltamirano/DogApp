package com.example.dogapp.domain

interface Response<T> {

    fun toEntity(): T

}