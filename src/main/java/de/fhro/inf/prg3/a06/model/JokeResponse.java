package de.fhro.inf.prg3.a06.model;

import com.google.gson.annotations.SerializedName;

public class JokeResponse {

    @SerializedName("type") private String responseType;
    @SerializedName("value") private Joke receivedJoke;

    public String getResponseType() {
        return responseType;

    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public Joke getReceivedJoke() {
        return receivedJoke;
    }

    public void setReceivedJoke(Joke receivedJoke) {
        this.receivedJoke = receivedJoke;
    }

}
