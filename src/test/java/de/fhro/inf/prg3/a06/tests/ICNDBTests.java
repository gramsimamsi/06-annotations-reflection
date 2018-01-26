package de.fhro.inf.prg3.a06.tests;

import de.fhro.inf.prg3.a06.ICNDBApi;
import de.fhro.inf.prg3.a06.model.Joke;
import de.fhro.inf.prg3.a06.model.JokeResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Peter Kurfer
 * Created on 11/10/17.
 */
class ICNDBTests {

	private static final Logger logger = LogManager.getLogger(ICNDBTests.class);
	private static final int REQUEST_COUNT = 100;

	@Test
	void testCollision() throws IOException {
		Set<Integer> jokeNumbers = new HashSet<>();
		int requests = 0;
		boolean collision = false;


		Retrofit retrofit = new Retrofit.Builder().baseUrl("http://api.icndb.com/").addConverterFactory(GsonConverterFactory.create()).build();
		ICNDBApi service = retrofit.create(ICNDBApi.class);
		Call<JokeResponse> call;
		Response<JokeResponse> response = null;

		while (requests++ < REQUEST_COUNT) {
			// TODO Prepare call object
			// done before loop!
			// TODO Perform a synchronous request
			call = service.getRandomJoke().clone();
			response = call.execute();
			// TODO Extract object


			Joke j = response.body().getReceivedJoke();

			if(jokeNumbers.contains(j.getNumber())) {
				logger.info(String.format("Collision at joke %s", j.getNumber()));
				collision = true;
				break;
			}

			jokeNumbers.add(j.getNumber());
			logger.info(j.toString());
		}

		assertTrue(collision, String.format("Completed %d requests without collision; consider increasing REQUEST_COUNT", requests));
	}
}
