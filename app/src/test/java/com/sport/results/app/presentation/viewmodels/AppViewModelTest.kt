package com.sport.results.app.presentation.viewmodels

import com.sport.results.app.domain.model.SportModel
import com.sport.results.app.domain.usecase.GetResultUseCase
import com.sport.results.app.utils.Resource
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

@ExperimentalCoroutinesApi
class AppViewModelTest {

    private lateinit var viewModel: AppViewModel
    private val getResultUseCase = mockk<GetResultUseCase>()

    @BeforeEach
    fun setup() {
        // Set the test dispatcher as the Main dispatcher
        kotlinx.coroutines.Dispatchers.setMain(kotlinx.coroutines.Dispatchers.Unconfined)
        viewModel = AppViewModel(getResultUseCase)
    }

    @AfterEach
    fun tearDown() {
        // Reset the main dispatcher after the test
        kotlinx.coroutines.Dispatchers.resetMain()
    }

    @Test
    fun `test getResults success`() = runTest {
        // Given
        val fOneResults = listOf(
            SportModel(
                publicationDate = "May 9, 2020 8:09:03 PM",
                seconds = 5.856,
                tournament = "Silverstone Grand Prix",
                winner = "Lewis Hamilton"
            )
        )

        val tennisResults = listOf(
            SportModel(
                looser = "Schwartzman ",
                numberOfSets = 3,
                publicationDate = "May 9, 2020 11:15:15 PM",
                tournament = "Roland Garros",
                winner = "Rafael Nadal"
            )
        )

        coEvery { getResultUseCase.execute() } returns flow {
            emit(Resource.Success(mapOf("F1" to fOneResults, "Tennis" to tennisResults)))
        }

        // When
        val result = viewModel.getResults().first()

        // Then
        assert(result is Resource.Success)
        assertEquals(fOneResults, (result as Resource.Success).value["F1"])
        assertEquals(tennisResults, result.value["Tennis"])
    }

    @Test
    fun `test setResponse`() = runTest {
        // When
        viewModel.setResponse(emptyMap())

        // Then
        assertEquals(emptyMap<String, List<SportModel>>(), viewModel.uiState.value.map)
        assertEquals(false, viewModel.uiState.value.isLoading)
    }

    @Test
    fun `test isLoading`() = runTest {
        // When
        viewModel.isLoading(true)

        // Then
        assertEquals(true, viewModel.uiState.value.isLoading)
        assertEquals("", viewModel.uiState.value.error)
        assertEquals(false, viewModel.uiState.value.showError)
    }

    @Test
    fun `test setError`() = runTest {
        // When
        viewModel.setError("Some error")

        // Then
        assertEquals("Some error", viewModel.uiState.value.error)
        assertEquals(true, viewModel.uiState.value.showError)
        assertEquals(false, viewModel.uiState.value.isLoading)
    }
}