package backend.academy.hangman.View;

import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@NoArgsConstructor
public class StatisticsView {
    private static final Logger LOGGER = LogManager.getLogger(StatisticsView.class);

    public void displayStatistics(String statistics) {
        LOGGER.info("Statistics:\n{}", statistics);
    }
}
