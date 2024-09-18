package backend.academy.tests;

import backend.academy.hangman.Model.GameSession;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameSessionTest {

    @Test
    public void testFullConstructor() {
        GameSession gameSession = new GameSession("example", 3, "won");
        assertEquals("example", gameSession.word());
        assertEquals(3, gameSession.attempt());
        assertEquals("won", gameSession.status());
    }

    @Test
    public void testSingleWordConstructor() {
        GameSession gameSession = new GameSession("example");
        assertEquals("example", gameSession.word());
        assertEquals(0, gameSession.attempt());
        assertEquals("in game...", gameSession.status());
    }

    @Test
    public void testSetters() {
        GameSession gameSession = new GameSession("test");
        gameSession.word("newWord");
        gameSession.attempt(5);
        gameSession.status("lost");

        assertEquals("newWord", gameSession.word());
        assertEquals(5, gameSession.attempt());
        assertEquals("lost", gameSession.status());
    }

    @Test
    public void testToString() {
        GameSession gameSession = new GameSession("example", 3, "won");
        String expected = "Word: example; Attempt: 3; Status: won";
        assertEquals(expected, gameSession.toString());
    }
}
