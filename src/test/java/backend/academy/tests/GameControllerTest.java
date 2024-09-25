package backend.academy.tests;

import backend.academy.hangman.Controller.GameController;
import backend.academy.hangman.Entity.WordEntity;
import backend.academy.hangman.Model.StatisticsModel;
import backend.academy.hangman.View.GameView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class GameControllerTest {
    @Mock
    private WordEntity wordEntity;
    @Mock
    private StatisticsModel statisticsModel;
    @Mock
    private GameView gameView;
    @Mock
    private GameController gameController;

    @BeforeEach
    void setUp() {
        wordEntity = mock(WordEntity.class);
        statisticsModel = mock(StatisticsModel.class);
        gameView = mock(GameView.class);
        when(wordEntity.word()).thenReturn("test");
        when(wordEntity.type()).thenReturn("noun");
        gameController = new GameController(wordEntity, statisticsModel, gameView);
    }

    @Test
    void testStartGame_Win() {
        GameController gameControllerSpy = spy(gameController);
        doReturn("t").doReturn("e").doReturn("s").doReturn("menu").when(gameControllerSpy).input();

        gameControllerSpy.startGame();

        InOrder inOrder = inOrder(gameView, statisticsModel);

        inOrder.verify(gameView).greetingOutput();
        inOrder.verify(gameView).printWordType("noun");
        inOrder.verify(gameView).gameWonOutput("test");
        inOrder.verify(statisticsModel).addGameInStatistic(any());

        //verify(gameView, times(3)).printWarning();
        verify(gameView, never()).gameLossOutput(anyString());
    }

    @Test
    void testStartGame_Loss() {
        GameController gameControllerSpy = spy(gameController);
        doReturn("x").doReturn("y").doReturn("z").doReturn("q").doReturn("w").doReturn("r").doReturn("m").when(gameControllerSpy).input();

        gameControllerSpy.startGame();
        InOrder inOrder = inOrder(gameView, statisticsModel);

        inOrder.verify(gameView).greetingOutput();
        inOrder.verify(gameView).printWordType("noun");
        inOrder.verify(gameView).gameLossOutput("test");
        inOrder.verify(statisticsModel).addGameInStatistic(any());

        verify(gameView, never()).gameWonOutput(anyString());
    }
}
