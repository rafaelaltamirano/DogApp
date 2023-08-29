package com.example.dogapp.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.dogapp.domain.entities.DogBreed
import com.example.dogapp.ui.ViewModelWithStatus
import com.example.dogapp.usecase.HomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeUseCase: HomeUseCase
) : ViewModelWithStatus() {

    var state by mutableStateOf(HomeState())
        private set

    init {
//        requestDogs()
    }

    private fun setLoading(loading: Boolean) {
        state = state.copy(loading = loading)
    }
    fun setDogBreed(dogBreed: List<DogBreed>?) {
        state = state.copy(dogBreed = dogBreed)
    }

     fun requestDogs() = viewModelScope.launch {
        try {
            setLoading(true)
            withContext(Dispatchers.IO) {
                homeUseCase.loadDogs()
            }.also { setDogBreed(it) }
        } catch (e: Exception) {
            handleNetworkError(e)
        } finally {
            setLoading(false)
        }
    }

}