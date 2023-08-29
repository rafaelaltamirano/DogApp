package com.example.dogapp.domain.response

import com.example.dogapp.domain.Response
import com.example.dogapp.domain.entities.DogBreed
import com.google.gson.annotations.SerializedName


 class DogBreedsResponse(
     @SerializedName("message") val message: Map<String, List<String>>,
     @SerializedName("status") val status: String
): Response<List<DogBreed>> {
    override fun toEntity(): List<DogBreed> {
         val breedList = mutableListOf<DogBreed>()
         for ((breed, subBreeds) in message) {
             breedList.add(DogBreed(breed, subBreeds))
         }
         return breedList
     }
 }

//data class DogBreedsResponse(
//    val status: String,
//    val message: Map<String, List<String>>,
//) {
//    companion object {
//        const val SUCCESS_STATUS = "success"
//    }
//}

/** A data class is a class that only contains state and does not perform any operation. **/
//data class DogBreedImagesResponse(
//    val status: String,
//    val message: List<String>,
//)

class DogBreedImagesResponse(
    @SerializedName("message") val message: List<String>,
    @SerializedName("status") val status: String
): Response<List<String>> {
    override fun toEntity(): List<String> {
        val imageList = mutableListOf<String>()
        for (image in message) {
            imageList.add(image)
        }
        return imageList
    }
}
