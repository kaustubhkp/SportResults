package com.sport.results.app.di

import com.sport.results.app.data.repository.RemoteRepositoryImpl
import com.sport.results.app.domain.repository.RemoteRepository
import com.sport.results.app.utils.EndPoints
import com.sport.results.app.data.remote.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addNetworkInterceptor {
                val requestBuilder: Request.Builder = it.request().newBuilder()
                requestBuilder.header("Content-Type", "application/json")
                it.proceed(requestBuilder.build())
            }
            .addNetworkInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

    @Provides
    @Singleton
    fun provideRemoteDataSource(client: OkHttpClient): RemoteDataSource =
        Retrofit.Builder()
            .baseUrl(EndPoints.baseURL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RemoteDataSource::class.java)

    @Provides
    @Singleton
    fun provideDataRepository(remoteDataSource: RemoteDataSource): RemoteRepository =
        RemoteRepositoryImpl(remoteDataSource)
}
