package backend.academy.tests;

import backend.academy.hangman.Controller.ValidatorController;
import backend.academy.hangman.Entity.CommandInGameEnum;
import backend.academy.hangman.Entity.ResultGameEnum;
import backend.academy.hangman.Entity.WordEntity;
import backend.academy.hangman.Model.GameService;
import backend.academy.hangman.Model.GameSession;
import backend.academy.hangman.Model.StatisticsModel;
import backend.academy.hangman.Model.WordCollectorModel;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class GameServiceTest {
    @InjectMocks
    private GameService gameService;
    @Mock
    private WordEntity wordEntity;
    @Mock
    private StatisticsModel statistics;
    @Mock
    private ValidatorController validator;
    @Mock
    private WordCollectorModel wordCollectorModel;
    @Mock
    private GameSession gameSession;

    @BeforeEach
    void setUp() {
//        wordEntity = mock(WordEntity.class);
//        statistics = mock(StatisticsModel.class);
//        validator = mock(ValidatorController.class);
//        wordCollectorModel = mock(WordCollectorModel.class);
//        gameSession = mock(GameSession.class);
        MockitoAnnotations.openMocks(this);

        when(wordEntity.word()).thenReturn("hello");

        // gameService = new GameService(wordEntity, statistics, validator, wordCollectorModel);
    }

    @Test
    void testIsGameOver_initiallyFalse() {
        assertFalse(gameService.isGameOver());
    }

    @Test
    void testIsGameOver_gameLost() {
        for (int i = 1; i <= 6; i++) {
            gameService.checkingWhetherWordCollected('x');
        }
        assertTrue(gameService.isGameOver());
    }

    @Test
    void testIsGameOver_gameWon() {
        when(wordCollectorModel.getLetters()).thenReturn(List.of('h', 'e', 'l', 'o'));
        gameService.checkingWhetherWordCollected('h');
        gameService.checkingWhetherWordCollected('e');
        gameService.checkingWhetherWordCollected('l');
        gameService.checkingWhetherWordCollected('o');
        assertTrue(gameService.isGameOver());
        assertEquals(ResultGameEnum.WIN, gameService.resultOfGame());
    }

    @Test
    void testIsCommand_validCommand() {
        assertTrue(gameService.isCommand(CommandInGameEnum.EXIT.command));
    }

    @Test
    void testIsCommand_invalidCommand() {
        assertFalse(gameService.isCommand("invalid"));
    }

    @Test
    void testIsErrorThrown_noError() {
        when(validator.checkInput("valid")).thenReturn(true);
        assertFalse(gameService.isErrorThrown("valid"));
    }

    @Test
    void testIsErrorThrown_errorThrown() {
        when(validator.checkInput("invalid")).thenReturn(false);
        assertTrue(gameService.isErrorThrown("invalid"));
    }

    @Test
    void testCheckingEnteredLetter_containsLetter() {
        when(wordCollectorModel.getLetters()).thenReturn(List.of('h'));
        assertTrue(gameService.checkingEnteredLetter('h'));
    }

    @Test
    void testCheckingEnteredLetter_doesNotContainLetter() {
        when(wordCollectorModel.getLetters()).thenReturn(List.of('h'));
        assertFalse(gameService.checkingEnteredLetter('e'));
    }

    @Test
    void testAddLetterToWordCollectorModel() {
        gameService.addLetterToWordCollectorModel('a');
        verify(wordCollectorModel).addLetter('a');
    }

    @Test
    void testGetWordWithGuessedLetters() {
        when(wordCollectorModel.getLetters()).thenReturn(List.of('h', 'e'));
        assertEquals("he___", gameService.getWordWithGuessedLetters());
    }

    @Test
    void testChangeResultOfGame() {
        gameService.changeResultOfGame(ResultGameEnum.WIN);
        assertEquals(ResultGameEnum.WIN, gameService.resultOfGame());
    }

    @Test
    void testChangeActiveGameShutdown() {
        gameService.changeActiveGameShutdown();
        assertFalse(gameService.isActiveGame());
    }

    @Test
    void testAddGameInStatistic() {
        gameService.addGameInStatistic(gameSession);
        verify(statistics).addGameInStatistic(gameSession);
    }

    @Test
    void testChangeStatusGameSession() {
        gameService.changeResultOfGame(ResultGameEnum.WIN);
        gameService.changeStatusGameSession(gameSession);
        verify(gameSession).status(ResultGameEnum.WIN.valueResult());
    }

    @Test
    void testGetStringAboutAllCommands() {
        String commands = gameService.getStringAboutAllCommands();
        assertNotNull(commands);
    }
}
