package de.fhro.inf.prg3.a06.tests;

import com.google.gson.Gson;
import de.fhro.inf.prg3.a06.model.Joke;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JokeTests {

    private static final Logger logger = LogManager.getLogger(ICNDBTests.class);
    private static final String TestJSONjoke = "{ \"id\": 558, \"joke\": \"Ghosts are actually caused by Chuck Norris killing people faster than Death can process them.\", \"categories\": [] }";

    @Test
    void testDeserialization(){
        logger.info("Testing for correct function of Joke deserialization");

        Gson gson = new Gson();

        Joke deserializedJoke = gson.fromJson(TestJSONjoke, Joke.class);

        assertEquals(deserializedJoke.getNumber(), 558);
        assertEquals(deserializedJoke.getContent(), "Ghosts are actually caused by Chuck Norris killing people faster than Death can process them.");
        assertEquals(deserializedJoke.getRubrics().length, 0);
    }
}
