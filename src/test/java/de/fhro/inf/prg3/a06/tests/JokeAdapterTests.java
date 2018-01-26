package de.fhro.inf.prg3.a06.tests;

import com.google.gson.stream.JsonReader;
import de.fhro.inf.prg3.a06.JokeAdapter;
import de.fhro.inf.prg3.a06.model.Joke;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JokeAdapterTests {

    private static final Logger logger = LogManager.getLogger(ICNDBTests.class);
    private static final String TestJokeResponseString = "{ \"type\": \"success\", \"value\": { \"id\": 467, \"joke\": \"Chuck Norris can delete the Recycling Bin.\", \"categories\": [ \"nerdy\" ] } }";

    @Test
    void testDeserialization(){
        logger.info("Testing for correct function of JokeAdapter deserialization");

        JokeAdapter adapter = new JokeAdapter();
        JsonReader in = new JsonReader(new StringReader(TestJokeResponseString));
        Joke jokeReceived = new Joke();
        try {
            jokeReceived = adapter.read(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals(467, jokeReceived.getNumber());
        assertEquals("Chuck Norris can delete the Recycling Bin.", jokeReceived.getContent());
        assertEquals("nerdy", jokeReceived.getRubrics()[0]);
        assertEquals(1, jokeReceived.getRubrics().length);

    }
}
