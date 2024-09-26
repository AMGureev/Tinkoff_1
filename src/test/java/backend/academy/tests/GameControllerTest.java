package backend.academy.tests;

import backend.academy.hangman.Controller.GameController;
import backend.academy.hangman.Entity.CommandInGameEnum;
import backend.academy.hangman.Entity.ResultGameEnum;
import backend.academy.hangman.Entity.WordEntity;
import backend.academy.hangman.Model.GameService;
import backend.academy.hangman.Model.HangmanStagesModel;
import backend.academy.hangman.Model.WordCollectorModel;
import backend.academy.hangman.View.GameView;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GameControllerTest {

    @Mock
    private GameService gameService;

    @Mock
    private GameView gameView;

    @Mock
    private WordCollectorModel wordCollectorModel;

    @Mock
    private HangmanStagesModel hangmanStageModel;

    @InjectMocks
    private GameController gameController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void startGame_ShouldDisplayWinningMessage_WhenPlayerWins() {
        String input = "t\ne\ns\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        WordEntity wordEntity = new WordEntity("test", "type", "hint");
        when(gameService.wordToGuess()).thenReturn(wordEntity);
        when(gameService.hangmanStageModel()).thenReturn(hangmanStageModel);
        when(gameService.wordCollectorModel()).thenReturn(wordCollectorModel);
        when(gameService.resultOfGame()).thenReturn(ResultGameEnum.WIN);
        when(gameService.isActiveGame()).thenReturn(true);
        when(gameService.isGameOver()).thenReturn(false).thenReturn(false).thenReturn(false).thenReturn(true);
        when(gameService.wordToGuess()).thenReturn(wordEntity);
        when(gameService.wordCollectorModel().getLetters()).thenReturn(List.of('t', 'e', 's'));
        gameController.startGame();
        verify(gameView).greetingOutput();
        verify(gameView).printWordType("type");
        verify(gameView).gameWonOutput(wordEntity.word());
    }

    @Test
    void startGame_ShouldDisplayLosingMessage_WhenPlayerLoses() {
        String input = "a\nb\nc\nd\nf\ns\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        WordEntity wordEntity = new WordEntity("test", "type", "hint");
        when(gameService.wordToGuess()).thenReturn(wordEntity);
        when(gameService.hangmanStageModel()).thenReturn(hangmanStageModel);
        when(gameService.wordCollectorModel()).thenReturn(wordCollectorModel);
        when(gameService.resultOfGame()).thenReturn(ResultGameEnum.DEFEAT);
        when(gameService.isActiveGame()).thenReturn(true);
        when(gameService.isGameOver()).thenReturn(false).thenReturn(false).thenReturn(false).thenReturn(true);
        when(gameService.wordToGuess()).thenReturn(wordEntity);
        when(gameService.wordCollectorModel().getLetters()).thenReturn(List.of('a'));
        gameController.startGame();
        verify(gameView).greetingOutput();
        verify(gameView).printWordType("type");
        verify(gameView).gameLossOutput(wordEntity.word());
    }

    @Test
    void processCommand_ShouldPrintHint_WhenCommandIsGetHint() {
        gameController.processCommand(CommandInGameEnum.GET_HINT);
        verify(gameView).printHint(gameService.wordToGuess());
    }

    @Test
    void processCommand_ShouldReturnToMenu_WhenCommandIsMenu() {
        gameController.processCommand(CommandInGameEnum.MENU);
        verify(gameView).returnOutput();
        verify(gameService).changeActiveGameShutdown();
    }

    @Test
    void displayGameStatus_ShouldShowCurrentStatusOfGame() {
        when(gameService.hangmanStageModel()).thenReturn(hangmanStageModel);
        when(gameService.getWordWithGuessedLetters()).thenReturn("anyString()");
        when(gameService.wordCollectorModel()).thenReturn(wordCollectorModel);
        when(gameService.getStringAboutAllCommands()).thenReturn("anyString()");

        gameController.displayGameStatus();

        verify(gameView).printGallows(gameService.hangmanStageModel());
        verify(gameView).printGameLineWithDashes(gameService.getWordWithGuessedLetters());
        verify(gameView).printListOfLettersUsed(gameService.wordCollectorModel().getLetters());
        verify(gameView).printAllCommands(gameService.getStringAboutAllCommands());
    }
}
