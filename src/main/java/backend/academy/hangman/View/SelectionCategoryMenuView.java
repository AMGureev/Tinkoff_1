package backend.academy.hangman.View;

import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@NoArgsConstructor
public class SelectionCategoryMenuView {
    private static final Logger LOGGER = LogManager.getLogger(SelectionCategoryMenuView.class);

    public void printHeading() {
        LOGGER.info("Choose your category");
    }

    public void displaySetLevel() {
        LOGGER.info("Choose your level");
        LOGGER.info("[1] Easy level (The length of the words is up to 5 characters)");
        LOGGER.info("[OTHER] Hard level (The words have a minimum of 6 characters)");
    }

    public void printChoiceCategory(String choice) {
        LOGGER.info("Your category: {}", choice);
    }

    public void printChoiceLevel(String choice) {
        LOGGER.info("Your level: {}", choice);
    }
}
