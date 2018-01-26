package de.fhro.inf.prg3.a06;

import de.fhro.inf.prg3.a06.model.Joke;
import de.fhro.inf.prg3.a06.model.JokeResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

/**
 * @author Peter Kurfer
 * Created on 11/10/17.
 */
public interface ICNDBApi {

    @Headers("accept: application/json")
    @GET("jokes/random")
    Call<JokeResponse> getRandomJoke();

    @Headers("accept: application/json")
    @GET("jokes/random")
    Call<JokeResponse> getRandomJoke(@Query("limitTo")String[] categoriesToInclude);

    @Headers("accept: application/json")
    @GET("jokes/random/{count}")
    Call<JokeResponse>[] getRandomJokes(@Query("count")int count);

    @Headers("accept: application/json")
    @GET("jokes/{id}")
    Call<JokeResponse> getJokeById(@Path("id")int id);

}
