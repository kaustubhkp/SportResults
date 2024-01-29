package com.sport.results.app.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sport.results.app.domain.model.SportModel
import com.sport.results.app.domain.usecase.GetResultUseCase
import com.sport.results.app.presentation.home.HomeUiState
import com.sport.results.app.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(private val getResultUseCase: GetResultUseCase) :
    ViewModel() {

    //  UI STATE
    val _uiState = MutableStateFlow(HomeUiState())
    val uiState: MutableStateFlow<HomeUiState>
        get() = _uiState


    suspend fun getResults(): Flow<Resource<Map<String, List<SportModel>>>> = getResultUseCase.execute()

    suspend fun setResponse(map : Map<String, List<SportModel>>) {
        viewModelScope.launch {
            _uiState.emit(_uiState.value.copy(map = map , isLoading = false))
        }
    }

    suspend fun isLoading(loading: Boolean) {
        viewModelScope.launch {
            _uiState.emit(_uiState.value.copy(isLoading = loading, error = "", showError = false))
        }
    }

    suspend fun setError(error: String) {
        viewModelScope.launch {
            _uiState.emit(_uiState.value.copy(error = error, showError = true , isLoading = false))
        }
    }


}