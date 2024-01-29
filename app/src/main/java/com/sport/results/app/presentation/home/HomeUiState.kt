package com.sport.results.app.presentation.home

import com.sport.results.app.domain.model.SportModel

data class HomeUiState(
    var isLoading: Boolean = false,
    var map: Map<String, List<SportModel>>? = null,
    var showError : Boolean = false,
    var error: String? =null,
)
