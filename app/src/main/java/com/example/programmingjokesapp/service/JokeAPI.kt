package com.example.programmingjokesapp.service

import com.example.programmingjokesapp.model.Joke
import retrofit2.http.GET

interface JokeAPI {

    // Source -> https://sv443.net/jokeapi/v2/

    @GET("atilsamancioglu/ProgrammingJokesJSON/refs/heads/main/jokes.json")
    suspend fun getData(): List<Joke>

}