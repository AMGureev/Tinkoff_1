package backend.academy.tests;

import backend.academy.hangman.Controller.GameStatisticsController;
import backend.academy.hangman.Model.StatisticsModel;
import backend.academy.hangman.View.StatisticsView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class GameStatisticsControllerTest {

    @Mock
    private GameStatisticsController controller;
    @Mock
    private StatisticsModel mockModel;
    @Mock
    private StatisticsView mockView;

    @BeforeEach
    void setUp() {
        mockModel = mock(StatisticsModel.class);
        mockView = mock(StatisticsView.class);
        controller = new GameStatisticsController(mockModel, mockView);
    }

    @Test
    void testDisplayStatistics() {
        when(mockModel.toString()).thenReturn("Test statistics");
        controller.displayStatistics();
        verify(mockView).displayStatistics("Test statistics");
    }
}
