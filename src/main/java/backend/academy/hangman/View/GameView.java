package backend.academy.hangman.View;

import backend.academy.hangman.Entity.WordEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GameView {
    private static final Logger LOGGER = LogManager.getLogger(GameView.class);

    public void greetingOutput() {
        LOGGER.info("Welcome to the Hangman game!");
    }

    public void printRemainingAttempts(int attempts) {
        LOGGER.info("Maximum number of attempts: {}", attempts);
    }

    public void printHint(WordEntity word) {
        LOGGER.info("Hint: {}", word.hint());
    }

    public void goodbyeOutput() {
        LOGGER.info("Exiting the game...");
    }

    public void printWordType(String type) {
        LOGGER.info("Word type: {}", type);
    }

    public void gameWonOutput(String word) {
        LOGGER.info("Congratulations! You guessed the word: {}", word);
    }

    public void gameLossOutput(String word) {
        LOGGER.info("Game Over! The word was: {}", word);
    }

    public void returnOutput() {
        LOGGER.info("Returning to the main menu...");
    }

    public void printWarning() {
        LOGGER.info("You already guessed this letter.");
    }
}
