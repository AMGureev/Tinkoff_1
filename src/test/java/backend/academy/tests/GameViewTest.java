package backend.academy.tests;

import backend.academy.hangman.Entity.WordEntity;
import backend.academy.hangman.View.GameView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class GameViewTest {

    private GameView gameView;

    @BeforeEach
    public void setUp() {
        gameView = new GameView();
    }

    @Test
    public void testGreetingOutput() {
        assertDoesNotThrow(() -> gameView.greetingOutput());
    }

    @Test
    public void testPrintHint() {
        WordEntity word = new WordEntity("animal", "cat", "Small pet");
        assertDoesNotThrow(() -> gameView.printHint(word));
    }

    @Test
    public void testGoodbyeOutput() {
        assertDoesNotThrow(() -> gameView.goodbyeOutput());
    }

    @Test
    public void testPrintWordType() {
        assertDoesNotThrow(() -> gameView.printWordType("noun"));
    }

    @Test
    public void testGameWonOutput() {
        assertDoesNotThrow(() -> gameView.gameWonOutput("cat"));
    }

    @Test
    public void testGameLossOutput() {
        assertDoesNotThrow(() -> gameView.gameLossOutput("cat"));
    }

    @Test
    public void testReturnOutput() {
        assertDoesNotThrow(() -> gameView.returnOutput());
    }

    @Test
    public void testPrintWarning() {
        assertDoesNotThrow(() -> gameView.printWarning());
    }
}
