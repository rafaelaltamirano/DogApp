package com.example.dogapp.framework.api

import com.example.dogapp.domain.ResponseWrapper
import com.example.dogapp.domain.response.DogBreedsResponse
import retrofit2.Response
import retrofit2.http.GET


interface DogsApi {

    @GET("breeds/list/all")
    suspend fun getDogs(): Response<ResponseWrapper<DogBreedsResponse>>
}