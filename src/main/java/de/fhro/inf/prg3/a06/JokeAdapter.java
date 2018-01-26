package de.fhro.inf.prg3.a06;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import de.fhro.inf.prg3.a06.model.Joke;
import de.fhro.inf.prg3.a06.model.JokeResponse;

import java.io.IOException;

public class JokeAdapter extends TypeAdapter {

    Gson gson = new Gson();

    @Override
    public void write(JsonWriter out, Object value) throws IOException {
        //not needed, hence not implemented!
        throw new RuntimeException("jokeAdapter.write is not implemented!");
    }

    @Override
    public Joke read(JsonReader in) throws IOException {

        JokeResponse jokeResponse = gson.fromJson(in, JokeResponse.class);
        if(jokeResponse.getResponseType().equals("success"))
            return jokeResponse.getReceivedJoke();
        else
            throw new IOException("JokeResponse type != success, something went wrong!");
    }
}
