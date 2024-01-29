package com.sport.results.app.domain.repository

import com.sport.results.app.domain.model.SportModel

interface RemoteRepository {
    suspend fun getResult(): Map<String, List<SportModel>>
}