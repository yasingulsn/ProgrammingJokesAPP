package com.example.programmingjokesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.programmingjokesapp.screens.JokeList
import com.example.programmingjokesapp.ui.theme.ProgrammingJokesAppTheme
import com.example.programmingjokesapp.viewmodel.JokeViewModel

class MainActivity : ComponentActivity() {

    private val viewModel : JokeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProgrammingJokesAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        viewModel.getJokes()
                        JokeList(jokeList = viewModel.jokeList.value)
                    }
                }
            }
        }
    }
}