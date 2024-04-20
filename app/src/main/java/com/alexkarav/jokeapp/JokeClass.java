package com.alexkarav.jokeapp;

public class JokeClass {
    public int id;
    public String type;
    public String setup;
    public String punchline;

    public JokeClass(int id, String type, String setup, String punchline) {
        this.id = id;
        this.type = type;
        this.setup = setup;
        this.punchline = punchline;
    }
}
