package backend.academy.hangman.View;

import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@NoArgsConstructor
public class SelectionCategoryMenuView {
    private static final Logger logger = LogManager.getLogger(SelectionCategoryMenuView.class);

    public void printHeading() {
        logger.info("Choose your category");
    }

    public void displaySetLevel() {
        logger.info("Choose your level");
        logger.info("[1] Easy level");
        logger.info("[2] Hard level");
    }
}
