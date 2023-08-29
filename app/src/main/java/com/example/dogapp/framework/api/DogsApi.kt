package com.example.dogapp.framework.api

import com.example.dogapp.domain.ResponseWrapper
import com.example.dogapp.domain.response.DogBreedImagesResponse
import com.example.dogapp.domain.response.DogBreedsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface DogsApi {

    @GET("breeds/list/all")
    suspend fun getDogs(): Response<DogBreedsResponse>

    @GET("breed/{breed_name}/images/random")
    suspend fun fetchDogBreedSingleImage(@Path("breed_name") breedName: String): Response<DogBreedImagesResponse>
}