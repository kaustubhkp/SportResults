package com.sport.results.app.domain.usecase

import com.sport.results.app.domain.model.SportModel
import com.sport.results.app.domain.repository.RemoteRepository
import com.sport.results.app.utils.Resource
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.IOException

@ExperimentalCoroutinesApi
class GetResultUseCaseTest {

    private lateinit var remoteRepository: RemoteRepository
    private lateinit var getResultUseCase: GetResultUseCase

    @BeforeEach
    fun setup() {
        remoteRepository = mockk()
        getResultUseCase = GetResultUseCase(remoteRepository)
    }

    @Test
    fun `test execute success`() = runTest {
        // Mocking successful response
        coEvery { remoteRepository.getResult() } returns emptyMap()

        val result = mutableListOf<Resource<Map<String, List<SportModel>>>>()

        // Launch a coroutine and collect the results
        getResultUseCase.execute().collect {
            result.add(it)
        }

        assertEquals(2, result.size) // Loading + Success
        assertEquals(Resource.Loading, result[0])
        assertEquals(Resource.Success(emptyMap<String, List<SportModel>>()), result[1])

        // Verify that the remoteRepository.getResult() was called
        coVerify(exactly = 1) { remoteRepository.getResult() }
    }

    @Test
    fun `test execute network error`() = runTest {
        // Mocking network error
        coEvery { remoteRepository.getResult() } throws IOException("Network error")

        val result = mutableListOf<Resource<Map<String, List<SportModel>>>>()

        // Launch a coroutine and collect the results
        getResultUseCase.execute().collect {
            result.add(it)
        }

        assertEquals(2, result.size) // Loading + Failure
        assertEquals(Resource.Loading, result[0])
        assertEquals(Resource.Failure(true, null, "Network error"), result[1])

        // Verify that the remoteRepository.getResult() was called
        coVerify(exactly = 1) { remoteRepository.getResult() }
    }

    @Test
    fun `test execute unknown error`() = runTest {
        // Mocking unknown error
        coEvery { remoteRepository.getResult() } throws RuntimeException("Unknown error")

        val result = mutableListOf<Resource<Map<String, List<SportModel>>>>()

        // Launch a coroutine and collect the results
        getResultUseCase.execute().collect {
            result.add(it)
        }

        assertEquals(2, result.size) // Loading + Failure
        assertEquals(Resource.Loading, result[0])
        assertEquals(Resource.Failure(true, null, "Unknown error"), result[1])

        // Verify that the remoteRepository.getResult() was called
        coVerify(exactly = 1) { remoteRepository.getResult() }
    }
}