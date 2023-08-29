package com.example.dogapp.ui.screens.home

import com.example.dogapp.domain.entities.DogBreed

data class HomeState(
    val loading: Boolean = false,
    val dogBreed: List<DogBreed>? = emptyList(),
)