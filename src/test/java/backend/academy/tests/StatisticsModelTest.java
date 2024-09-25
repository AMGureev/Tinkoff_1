package backend.academy.tests;

import backend.academy.hangman.Model.GameSession;
import backend.academy.hangman.Model.StatisticsModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StatisticsModelTest {

    private StatisticsModel statisticsModel;

    @BeforeEach
    public void setUp() {
        statisticsModel = new StatisticsModel();
    }

    @Test
    public void testInitialValues() {
        assertEquals(0, statisticsModel.countGame());
        assertTrue(statisticsModel.gameSessions().isEmpty());
    }

    @Test
    public void testAddGame() {
        GameSession gameSession = new GameSession("watermelon", 8, "win");

        statisticsModel.addGameInStatistic(gameSession);

        assertEquals(1, statisticsModel.countGame());
        assertEquals(1, statisticsModel.gameSessions().size());
        assertEquals(gameSession, statisticsModel.gameSessions().getFirst());
    }

    @Test
    public void testGetAllInfoStatisticsSingleGame() {
        GameSession gameSession = new GameSession("watermelon", 8, "win");
        statisticsModel.addGameInStatistic(gameSession);

        String expected = "Count game: 1\n" +
            "1. Word: watermelon; Attempt: 8; Status: win";

        assertEquals(expected, statisticsModel.getAllInfoStatistics());
    }

    @Test
    public void testGetAllInfoStatisticsMultipleGames() {
        GameSession gameSession1 = new GameSession("bad", 5, "win");
        GameSession gameSession2 = new GameSession("Loss", 8, "loss");

        statisticsModel.addGameInStatistic(gameSession1);
        statisticsModel.addGameInStatistic(gameSession2);

        String expected = """
            Count game: 2
            1. Word: bad; Attempt: 5; Status: win
            2. Word: Loss; Attempt: 8; Status: loss""";

        assertEquals(expected, statisticsModel.getAllInfoStatistics());
    }
}
