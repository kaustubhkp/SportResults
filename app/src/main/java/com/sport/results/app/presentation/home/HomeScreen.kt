package com.sport.results.app.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.sport.results.app.presentation.common.FullScreenLoader
import com.sport.results.app.presentation.viewmodels.AppViewModel
import com.sport.results.app.utils.NavigationItem
import com.sport.results.app.utils.Resource
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    navHostController: NavHostController? = null,
    viewModel: AppViewModel,
) {
    val uiState by viewModel.uiState.collectAsState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
                .padding(innerPadding)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (uiState.isLoading) {
                        FullScreenLoader()
                    } else {
                        Box(modifier = Modifier.padding(horizontal = 20.dp)) {
                            Button(
                                onClick = {
                                    coroutineScope.launch {
                                        viewModel.getResults().collect() { result ->
                                            when (result) {
                                                is Resource.Success -> {
                                                    viewModel.setResponse(result.value)
                                                    navHostController?.navigate(NavigationItem.Sports.route)
                                                }

                                                is Resource.Failure -> {
                                                    viewModel.setError(result.errorText?: "Something went wrong.")
                                                }

                                                is Resource.Loading -> {
                                                    viewModel.isLoading(true)
                                                }
                                            }
                                        }
                                    }

                                },
                                shape = RoundedCornerShape(10.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("Get Results", fontSize = 18.sp, color = Color.White)
                            }
                        }
                    }

                    if (uiState.showError) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 30.dp, end = 30.dp)
                        ) {
                            Text(
                                text = "${uiState.error}",
                                style = TextStyle(
                                    color = Color.Red,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                        }
                    }
                }
            }
        }

    }
}