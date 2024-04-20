package com.alexkarav.jokeapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainViewModel extends ViewModel {
    private MutableLiveData<JokeClass> _joke = new MutableLiveData<>(new JokeClass(0, "Пусто", "Здесь будет шутка: ", "Колобок повесился"));
    public LiveData<JokeClass> joke() { return _joke; }
    private JokeInterface api = new Retrofit.Builder().baseUrl("https://official-joke-api.appspot.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(JokeInterface.class);

    public MainViewModel() {
        postNewJoke();
    }

    public void postNewJoke() {
        api.getRandomJoke().enqueue(new Callback<List<JokeClass>>() {
            @Override
            public void onResponse(Call<List<JokeClass>> call, Response<List<JokeClass>> response) {
                if(response.isSuccessful()) {
                    _joke.postValue(response.body().get(0));
                }
            }

            @Override
            public void onFailure(Call<List<JokeClass>> call, Throwable t) {
                _joke.postValue(new JokeClass(0, "Error", "Произошла ошибка: ", t.getLocalizedMessage()));
            }
        });
    }
}
