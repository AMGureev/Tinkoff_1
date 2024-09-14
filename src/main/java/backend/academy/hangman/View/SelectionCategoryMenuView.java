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
        LOGGER.info("[1] Easy level");
        LOGGER.info("[2] Hard level");
    }
}
