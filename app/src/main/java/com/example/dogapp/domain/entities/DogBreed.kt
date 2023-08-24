package com.example.dogapp.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "dogBreed")
@TypeConverters(StringListConverter::class) // Add your type converter here
data class DogBreed(
    @PrimaryKey(autoGenerate = false) val breed: String,
    val subBreeds: List<String>
)