package com.sport.results.app.presentation.sports

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.sport.results.app.presentation.sports.composables.DateSection
import com.sport.results.app.presentation.viewmodels.AppViewModel

@Composable
fun SportsScreen(viewModel: AppViewModel) {

    val uiState by viewModel.uiState.collectAsState()

    Scaffold { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
                .padding(innerPadding)
        ) {
            Box (modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier.verticalScroll(rememberScrollState())
                ) {
                    
                    uiState.map?.entries?.forEach { entry->
                        DateSection(title = entry.key, sports = entry.value)
                    }
                }
            }
        }
    }
}