package com.sport.results.app.data.repository

import com.sport.results.app.data.remote.RemoteDataSource
import com.sport.results.app.domain.model.SportModel
import com.sport.results.app.domain.repository.RemoteRepository
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(private val dataSource: RemoteDataSource) :
    RemoteRepository {
    override suspend fun getResult(): Map<String, List<SportModel>> {
        return dataSource.getResults().getMap()
    }
}