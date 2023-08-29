package com.example.dogapp.framework.datasource.dogs

import android.util.Log
import com.example.dogapp.data.datasource.BreedsRemoteSource
import com.example.dogapp.domain.entities.DogBreed
import com.example.dogapp.framework.api.ApiTools
import com.example.dogapp.framework.api.DogsApi
import javax.inject.Inject


class BreedsRemoteSourceImp @Inject constructor(
    private val api: DogsApi
) : BreedsRemoteSource {

//    override suspend fun loadDogs(): List<DogBreed> {
//        val res = api.getDogs()
//        ApiTools.validateResponseOrFail(res)
//        return res.body()!!
//    }

    override suspend fun loadDogs(): List<DogBreed> {
        try {
            //No need to change context to Dispatchers.IO as Retrofit handles that automatically.
            val dogBreedList = mutableListOf<DogBreed>()
            val res = api.getDogs()
            val d: List<DogBreed> = res.body()!!.toEntity()
//            val d: List<DogBreed> = emptyList()
            return d
        } catch (e: Exception) {
            Log.d("Tagy", e.toString())
            throw e
        }
    }

//    override suspend fun loadDogs(): List<DogBreed> {
//        //No need to change context to Dispatchers.IO as Retrofit handles that automatically.
//        try {
//            val dogBreedList = mutableListOf<DogBreed>()
//            val res = api.fetchDogBreedSingleImage("pitbull")
//            Log.d("Tagy", res.message().toString())
//            val d: List<DogBreed> = emptyList()
//            return d
//        } catch (e: Exception) {
//            Log.d("Tagy", e.toString())
//            throw e
//        }
//    }
}