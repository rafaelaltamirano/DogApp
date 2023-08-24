package com.example.dogapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.dogapp.domain.entities.DogBreed

@Dao
interface DogBreedsDao {

    @Query("SELECT * FROM dogBreed")
    suspend fun getAll(): List<DogBreed>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(banks: List<DogBreed>)

    @Query("DELETE FROM dogBreed")
    suspend fun deleteAll()
}