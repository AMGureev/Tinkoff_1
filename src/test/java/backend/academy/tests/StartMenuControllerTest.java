package backend.academy.tests;

import backend.academy.hangman.Controller.GameStatisticsController;
import backend.academy.hangman.Controller.SelectionCategoryMenuController;
import backend.academy.hangman.Controller.StartMenuController;
import backend.academy.hangman.Model.StartMenu;
import backend.academy.hangman.View.StartMenuView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class StartMenuControllerTest {
    @Mock
    private StartMenuController controller;
    @Mock
    private StartMenuView view;
    @Mock
    private StartMenu model;
    @Mock
    private GameStatisticsController statisticsController;
    @Mock
    private SelectionCategoryMenuController stagesMenu;

    @BeforeEach
    public void setUp() {
        view = Mockito.mock(StartMenuView.class);
        model = Mockito.mock(StartMenu.class);
        statisticsController = Mockito.mock(GameStatisticsController.class);
        stagesMenu = Mockito.mock(SelectionCategoryMenuController.class);

        controller = new StartMenuController(view, model, statisticsController, stagesMenu);
    }

    @Test
    public void testStart_DisplayStartMenuAndSelection() {
        when(model.input()).thenReturn(3);
        controller.start();
        verify(view).displayStartMenu();
        verify(view).displaySelect();
        verify(view).displayGoodbye();
        verify(model).exit();
    }

    @Test
    public void testStart_SelectCategoryMenu() {
        when(model.input()).thenReturn(1, 3);
        controller.start();
        verify(view).displayStartMenu();
        verify(view, times(2)).displaySelect();
        verify(stagesMenu).chooseCategory();
        verify(view).displayGoodbye();
        verify(model).exit();
    }

    @Test
    public void testStart_DisplayUserStatistics() {
        when(model.input()).thenReturn(2, 3);
        controller.start();
        verify(view).displayStartMenu();
        verify(view, times(2)).displaySelect();
        verify(statisticsController).displayStatistics();
        verify(view).displayGoodbye();
        verify(model).exit();
    }

    @Test
    public void testStart_InvalidChoice() {
        when(model.input()).thenReturn(0, 3);

        controller.start();
        verify(view).displayError();
        verify(view).displayGoodbye();
        verify(model).exit();
    }
}
