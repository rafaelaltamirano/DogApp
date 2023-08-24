package com.example.dogapp.framework.datasource.dogs

import com.example.dogapp.data.dao.DogBreedsDao
import com.example.dogapp.data.datasource.BreedsLocalSource
import com.example.dogapp.domain.entities.DogBreed
import javax.inject.Inject

class BreedsLocalSourceImp @Inject constructor(private val dogBreedsDao: DogBreedsDao ) :
    BreedsLocalSource {

    override suspend fun save(t: List<DogBreed>) {

        dogBreedsDao.insertAll(t)
    }

    override suspend fun load(): List<DogBreed> {
        return dogBreedsDao.getAll()
    }

    override suspend fun clear() {
        return dogBreedsDao.deleteAll()
    }

}