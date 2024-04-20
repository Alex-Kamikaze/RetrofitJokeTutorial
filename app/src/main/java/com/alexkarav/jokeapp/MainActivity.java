package com.alexkarav.jokeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView jokeText;
    Button getNewJokeButton;
    MainViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jokeText = findViewById(R.id.jokeText);
        getNewJokeButton = findViewById(R.id.getNewJokeButton);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.joke().observe(this,
                jokeClass -> jokeText.setText(jokeClass.setup + " " + jokeClass.punchline));
        getNewJokeButton.setOnClickListener(view -> viewModel.postNewJoke());
    }
}