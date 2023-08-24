package com.example.dogapp.data.datasource

import com.example.dogapp.domain.entities.DogBreed

class DogsRepository(
    private val remote: BreedsRemoteSource,
    private val local: BreedsLocalSource
) : LocalSource<List<DogBreed>> {

    var dogBreed: List<DogBreed>? = emptyList()
        private set

    suspend fun searchImages(text: String) = remote.loadDogs(text).also { save(it) }

    override suspend fun save(t: List<DogBreed>) {
        dogBreed = t
        local.save(t)
    }


    override suspend fun load(): List<DogBreed> = (local.load() ?: emptyList()).also {
        this.dogBreed = it
    }

    override suspend fun clear() = local.clear().also { this.dogBreed = emptyList() }

}

interface BreedsRemoteSource {

    suspend fun loadDogs(text: String): List<DogBreed>

}

interface BreedsLocalSource : LocalSource<List<DogBreed>>