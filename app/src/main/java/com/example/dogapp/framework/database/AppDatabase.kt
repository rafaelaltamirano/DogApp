package com.example.dogapp.framework.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dogapp.data.dao.DogBreedsDao
import com.example.dogapp.domain.entities.DogBreed

@Database(entities = [DogBreed::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dogBreedsDao(): DogBreedsDao
}