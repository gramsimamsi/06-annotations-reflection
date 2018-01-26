package de.fhro.inf.prg3.a06;

import de.fhro.inf.prg3.a06.model.Joke;
import de.fhro.inf.prg3.a06.model.JokeResponse;
import jdk.nashorn.internal.ir.RuntimeNode;
import okhttp3.Request;
import org.omg.PortableInterceptor.RequestInfoOperations;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Converter.Factory;
import retrofit2.Converter.*;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

/**
 * @author Peter Kurfer
 * Created on 11/10/17.
 */
public class App {

	public static void main(String[] args) throws IOException {
		// TODO fetch a random joke and print it to STDOUT

		Retrofit retrofit = new Retrofit.Builder().baseUrl("http://api.icndb.com/").addConverterFactory(GsonConverterFactory.create()).build();

		ICNDBApi service = retrofit.create(ICNDBApi.class);

		//get one random joke
		Call<JokeResponse> call = service.getRandomJoke();
		Response<JokeResponse> response = call.execute();
		System.out.println(response.body().getReceivedJoke().getContent());

		//get one specific joke
		Call<JokeResponse> call2 = service.getJokeById(1);
		Response<JokeResponse> response2 = call2.execute();
		System.out.println(response2.body().getReceivedJoke().getContent());

		//get one random nerdy Joke
		Call<JokeResponse> call3 = service.getRandomJoke(new String[]{"nerdy"});
		Response<JokeResponse> response3 = call3.execute();
		System.out.println(response3.body().getReceivedJoke().getContent());

		/*
		//get multiple random jokes
		Call<List<JokeResponse>> call4 = service.getRandomJokes(3);
		Response<List<JokeResponse>> response4 = call4.execute();
		for(JokeResponse j: response4.body()){
			System.out.println(j.getReceivedJoke().getContent());
		}
		*/

	}

}
