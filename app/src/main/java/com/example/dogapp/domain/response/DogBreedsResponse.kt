package com.example.dogapp.domain.response

import com.example.dogapp.domain.Response
import com.example.dogapp.domain.entities.DogBreed
import com.google.gson.annotations.SerializedName


 class DogBreedsResponse(
    @SerializedName("breeds") val breeds: Map<String, List<String>>
): Response<List<DogBreed>> {
     override fun toEntity(): List<DogBreed> {
         val breedList = mutableListOf<DogBreed>()
         for ((breed, subBreeds) in breeds) {
             breedList.add(DogBreed(breed = breed, subBreeds = subBreeds))
         }
         return breedList
     }
 }