package com.sport.results.app.data.remote

import com.sport.results.app.domain.model.ResultResponse
import com.sport.results.app.utils.EndPoints
import retrofit2.http.POST

interface RemoteDataSource {
    @POST(EndPoints.results)
    suspend fun getResults(): ResultResponse

}