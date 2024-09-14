package backend.academy.hangman.View;

import backend.academy.hangman.Entity.WordEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GameView {
    private static final Logger logger = LogManager.getLogger(GameView.class);

    public void greetingOutput() {
        logger.info("Welcome to the Hangman game!");
    }

    public void printHint(WordEntity word) {
        logger.info("Hint: {}", word.hint());
    }

    public void goodbyeOutput() {
        logger.info("Exiting the game...");
    }

    public void printWordType(String type) {
        logger.info("Word type: {}", type);
    }

    public void gameWonOutput(String word) {
        logger.info("Congratulations! You guessed the word: {}", word);
    }

    public void gameLossOutput(String word) {
        logger.info("Game Over! The word was: {}", word);
    }

    public void returnOutput() {
        logger.info("Returning to the main menu...");
    }

    public void printWarning() {
        logger.info("You already guessed this letter.");
    }
}
