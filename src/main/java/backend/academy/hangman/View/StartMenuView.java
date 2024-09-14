package backend.academy.hangman.View;

import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@NoArgsConstructor
public class StartMenuView {
    private static final Logger LOGGER = LogManager.getLogger(StartMenuView.class);

    public void displayStartMenu() {
        LOGGER.info("Welcome to Hangman!");
    }

    public void displayGoodbye() {
        LOGGER.info("Goodbye!");
    }

    public void displaySelect() {
        LOGGER.info("[1] Start Game");
        LOGGER.info("[2] View Statistics");
        LOGGER.info("[3] Exit");
        LOGGER.info("Please select an option: ");
    }

    public void displayError() {
        LOGGER.info("Error: please, input integer[1-3]");
    }
}
