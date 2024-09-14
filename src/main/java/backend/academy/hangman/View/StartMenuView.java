package backend.academy.hangman.View;

import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@NoArgsConstructor
public class StartMenuView {
    private static final Logger logger = LogManager.getLogger(StartMenuView.class);

    public void displayStartMenu() {
        logger.info("Welcome to Hangman!");
    }

    public void displayGoodbye() {
        logger.info("Goodbye!");
    }

    public void displaySelect() {
        logger.info("[1] Start Game");
        logger.info("[2] View Statistics");
        logger.info("[3] Exit");
        logger.info("Please select an option: ");
    }

    public void displayError() {
        logger.info("Error: please, input integer[1-3]");
    }
}
