package com.alexkarav.jokeapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JokeInterface {
    @GET("/jokes/programming/random")
    Call<List<JokeClass>> getRandomJoke();
}

