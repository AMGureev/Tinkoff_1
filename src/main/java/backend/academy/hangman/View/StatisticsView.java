package backend.academy.hangman.View;

import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@NoArgsConstructor
public class StatisticsView {
    private static final Logger logger = LogManager.getLogger(StatisticsView.class);

    public void displayStatistics(String statistics) {
        logger.info("Statistics:\n{}", statistics);
    }
}
