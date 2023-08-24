package com.example.dogapp.framework.datasource.dogs

import com.example.dogapp.data.datasource.BreedsRemoteSource
import com.example.dogapp.domain.entities.DogBreed
import com.example.dogapp.framework.api.ApiTools
import com.example.dogapp.framework.api.DogsApi
import javax.inject.Inject



class BreedsRemoteSourceImp @Inject constructor(
    private val api: DogsApi
) : BreedsRemoteSource {

    override suspend fun loadDogs(text: String): List<DogBreed> {
        val res = api.getDogs()
        ApiTools.validateResponseOrFail(res)
        return res.body()!!.message.toEntity()
    }
}