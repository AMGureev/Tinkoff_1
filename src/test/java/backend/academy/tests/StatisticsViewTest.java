package backend.academy.tests;

import backend.academy.hangman.View.StatisticsView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class StatisticsViewTest {

    private StatisticsView statisticsView;

    @BeforeEach
    void setUp() {
        statisticsView = new StatisticsView();
    }

    @Test
    void testDisplayStartMenu() {
        assertDoesNotThrow(() -> statisticsView.displayStatistics("statistics"));
    }
}
