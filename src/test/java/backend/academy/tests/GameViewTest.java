package backend.academy.tests;

import backend.academy.hangman.Entity.WordEntity;
import backend.academy.hangman.Model.HangmanStagesModel;
import backend.academy.hangman.View.GameView;
import java.util.Arrays;
import java.util.List;
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
    public void testPrintWarningReuseOfTheLetter() {
        assertDoesNotThrow(() -> gameView.printWarningReuseOfTheLetter());
    }

    @Test
    public void testPrintAllCommands() {
        String gameCommands = "guess, hint, exit";
        assertDoesNotThrow(() -> gameView.printAllCommands(gameCommands));
    }

    @Test
    public void testPrintGameLineWithDashes() {
        String gameLineWithDashes = "___";
        assertDoesNotThrow(() -> gameView.printGameLineWithDashes(gameLineWithDashes));
    }

    @Test
    public void testPrintGallows() {
        HangmanStagesModel hangmanStageModel = HangmanStagesModel.STAGE_1;
        assertDoesNotThrow(() -> gameView.printGallows(hangmanStageModel));
    }

    @Test
    public void testPrintListOfLettersUsed() {
        List<Character> listOfLettersUsed = Arrays.asList('a', 'b', 'c');
        assertDoesNotThrow(() -> gameView.printListOfLettersUsed(listOfLettersUsed));
    }

    @Test
    public void testPrintLastValidatorError() {
        String errorMessage = "Invalid input!";
        assertDoesNotThrow(() -> gameView.printLastValidatorError(errorMessage));
    }

    @Test
    public void testPrintUnknownCommand() {
        assertDoesNotThrow(() -> gameView.printUnknownCommand());
    }
}
