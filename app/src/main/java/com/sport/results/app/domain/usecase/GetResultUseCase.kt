package com.sport.results.app.domain.usecase

import com.sport.results.app.domain.model.SportModel
import com.sport.results.app.domain.repository.RemoteRepository
import com.sport.results.app.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class GetResultUseCase @Inject constructor(private val remoteRepository: RemoteRepository) {
    suspend fun execute(): Flow<Resource<Map<String, List<SportModel>>>> {
        return flow {
            emit(Resource.Loading)
            val response = remoteRepository.getResult()
            emit(Resource.Success(response))
        }.catch { error ->
            when (error) {
                is HttpException -> {
                    emit(
                        Resource.Failure(
                            false,
                            error.code(),
                            error.localizedMessage
                        )
                    )
                }
                else -> {
                    emit(Resource.Failure(true, null, error.localizedMessage ?: "Unknown error"))
                }
            }
        }
    }
}