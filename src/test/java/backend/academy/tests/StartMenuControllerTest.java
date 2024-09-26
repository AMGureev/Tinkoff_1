package backend.academy.tests;

import backend.academy.hangman.Controller.GameStatisticsController;
import backend.academy.hangman.Controller.SelectionGameModeController;
import backend.academy.hangman.Controller.StartMenuController;
import backend.academy.hangman.Model.StartMenu;
import backend.academy.hangman.View.StartMenuView;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class StartMenuControllerTest {

    private StartMenuController startMenuController;
    private StartMenuView startMenuView;
    private StartMenu startMenuModel;
    private GameStatisticsController statisticsController;
    private SelectionGameModeController gameModeController;

    @BeforeEach
    void setUp() throws IOException {
        startMenuView = mock(StartMenuView.class);
        startMenuModel = mock(StartMenu.class);
        statisticsController = mock(GameStatisticsController.class);
        gameModeController = mock(SelectionGameModeController.class);

        startMenuController = Mockito.spy(new StartMenuController(
            startMenuView, startMenuModel, statisticsController, gameModeController
        ));
    }

    @Test
    void testDisplayUserStatisticsOption() throws IOException {
        String input = "2\n3\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        startMenuController.start();
        verify(statisticsController).displayStatistics();
    }

    @Test
    void testInvalidInput() throws IOException {
        String input = "5\n3\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        startMenuController.start();
        verify(startMenuView).displayError();
    }

    @Test
    void testExitProgram() throws IOException {
        String input = "3\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        startMenuController.start();
        verify(startMenuModel).exit();
        verify(startMenuView).displayGoodbye();
    }
}
