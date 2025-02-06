package com.example.programmingjokesapp.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import com.example.programmingjokesapp.model.Joke

@Composable
fun JokeList(jokeList: List<Joke>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFFBBDEFB), Color(0xFFE3F2FD))
                )
            )
            .padding(8.dp)
    ) {
        items(jokeList) { joke ->
            JokeRow(joke = joke)
        }
    }
}

@Composable
fun JokeRow(joke: Joke) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .shadow(4.dp, shape = RoundedCornerShape(12.dp))
            .border(BorderStroke(2.dp, Color(0xFF1565C0)), RoundedCornerShape(12.dp))
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFF42A5F5), Color(0xFF90CAF9))
                ),
                shape = RoundedCornerShape(12.dp)
            )
            .padding(12.dp)
    ) {
        if (joke.type == "twopart") {
            Column {
                Text(
                    text = "Setup: ${joke.setup}",
                    style = MaterialTheme.typography.headlineSmall.copy(fontSize = 20.sp),
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = "Delivery: ${joke.delivery}",
                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp),
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
            }
        } else {
            Text(
                text = joke.joke ?: "",
                style = MaterialTheme.typography.headlineSmall.copy(fontSize = 20.sp),
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}
