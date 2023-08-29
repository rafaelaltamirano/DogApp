package com.example.dogapp.usecase

import com.example.dogapp.data.datasource.DogsRepository
import com.example.dogapp.domain.entities.DogBreed
import javax.inject.Inject

class HomeUseCase @Inject constructor(private val dogsRepository: DogsRepository) {

    suspend fun loadDogs(): List<DogBreed> {
        return dogsRepository.loadDogs()
    }

}

