package backend.academy.tests;

import backend.academy.hangman.Controller.GameController;
import backend.academy.hangman.Controller.SelectionGameModeController;
import backend.academy.hangman.Entity.WordEntity;
import backend.academy.hangman.Model.SelectionGameMode;
import backend.academy.hangman.Model.StatisticsModel;
import backend.academy.hangman.View.GameView;
import backend.academy.hangman.View.SelectionCategoryMenuView;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

public class SelectionStagesMenuControllerTest {

    @Mock
    private SelectionGameMode model;

    @Mock
    private SelectionCategoryMenuView view;

    @Mock
    private GameView gameView;

    @Mock
    private StatisticsModel statisticsModel;

    @Mock
    private WordEntity wordEntity;

    @InjectMocks
    private SelectionGameModeController controller;

    @Mock
    private GameController game;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    private Scanner mockScanner;

    @Test
    public void testChooseCategory() {
        when(model.input()).thenReturn(1).thenReturn(1);
        doNothing().when(view).printHeading();
        doNothing().when(model).viewCategory();
        controller.chooseCategory();
        verify(view).printHeading();
        verify(model).viewCategory();
        verify(model, times(2)).input();
    }

    @Test
    public void testChooseLevelWithNullWord() {
        when(model.input()).thenReturn(1);
        when(model.getRandomWordByCategoryAndLevel(1, 1)).thenReturn(null);

        controller.chooseLevel(1);

        verify(view).displaySetLevel();
        verify(view).printChoiceLevel(model.getLevel(1));
        verify(model).getRandomWordByCategoryAndLevel(1, 1);
        verifyNoMoreInteractions(view);
    }

//    @Test
//    public void testChooseLevelWithValidWord() {
//        when(model.input()).thenReturn(1);
//        when(model.getRandomWordByCategoryAndLevel(1, 1)).thenReturn(new WordEntity("win", "game", "hint"));
//        when(game.input()).thenReturn("exit");
//        controller.chooseLevel(1);
//        verify(view).displaySetLevel();
//        verify(model).getRandomWordByCategoryAndLevel(1, 1);
//        verifyNoMoreInteractions(view);
//    }

    @Test
    public void testErrorLoggingForNullWord() {
        when(model.input()).thenReturn(1);
        when(model.getRandomWordByCategoryAndLevel(1, 1)).thenReturn(null);

        controller.chooseLevel(1);
        verify(model).getRandomWordByCategoryAndLevel(1, 1);
    }
}
