package backend.academy.hangman.View;

import backend.academy.hangman.Model.SelectionGameMode;
import java.util.List;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@NoArgsConstructor
public class SelectionGameModeView {
    private static final Logger LOGGER = LogManager.getLogger(SelectionGameModeView.class);

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

    public void viewCategory(SelectionGameMode selectionGameModeModel) {
        List<String> types = selectionGameModeModel.dictionary().getTypes();
        for (int i = 0; i < types.size(); i++) {
            LOGGER.info("[{}] {}", i, types.get(i));
        }
        LOGGER.info("[OTHER] random");
        LOGGER.info("Please select a category: ");
    }

    public void printErrorWordNotFound() {
        LOGGER.error("Error: there are no words of such complexity.");
    }

    public void printInputError() {
        LOGGER.error("Error: enter an integer.");
    }
}
