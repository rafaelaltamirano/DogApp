package com.example.dogapp.ui.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.dogapp.ui.ViewModelWithStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
) : ViewModelWithStatus() {

    var state by mutableStateOf(MainState())
        private set

    private fun setLoading(loading: Boolean) {
        state = state.copy(loading = loading)
    }


}