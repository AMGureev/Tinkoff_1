package backend.academy.hangman.Controller;

import backend.academy.hangman.Entity.CommandInGameEnum;
import backend.academy.hangman.Entity.ResultGameEnum;
import backend.academy.hangman.Model.GameService;
import backend.academy.hangman.Model.GameSession;
import backend.academy.hangman.View.GameView;
import com.google.inject.Inject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class GameController {
    private final GameService gameService;
    private final GameView gameView;
    private BufferedReader userInputStream;

    @Inject
    public GameController(
        GameService gameService,
        GameView gameView
    ) {
        this.gameService = gameService;
        this.gameView = gameView;
    }

    public void startGame() {
        GameSession gameSession = new GameSession(gameService.wordToGuess().word());
        userInputStream = new BufferedReader(new InputStreamReader(System.in));

        gameView.greetingOutput();
        gameView.printRemainingAttempts(gameService.hangmanStageModel().getMaxAttempts());
        gameView.printWordType(gameService.wordToGuess().type());

        while (!gameService.isGameOver()) {
            displayGameStatus();
            String userInput = input().toLowerCase();

            boolean isIncorrectUserInput = gameService.isErrorThrown(userInput);
            if (isIncorrectUserInput) {
                gameView.printLastValidatorError(gameService.validator().getLast().message());
            }

            boolean isUserInputCommand = gameService.isCommand(userInput);
            if (isUserInputCommand) {
                processCommand(CommandInGameEnum.getCommandByString(userInput));
            }

            if (!isIncorrectUserInput && !isUserInputCommand) {
                char userInputLetter = userInput.charAt(0);
                if (gameService.checkingEnteredLetter(userInputLetter)) {
                    gameView.printWarningReuseOfTheLetter();
                } else {
                    gameService.addLetterToWordCollectorModel(userInputLetter);
                    gameService.checkingWhetherWordCollected(userInputLetter);
                    addAttemptGameSession(gameSession);
                }
            }
        }
        if (!gameService.isActiveGame()) {
            return;
        }
        if (Objects.equals(gameService.resultOfGame(), ResultGameEnum.WIN)) {
            gameView.gameWonOutput(gameSession.word());
        } else {
            gameService.changeResultOfGame(ResultGameEnum.DEFEAT);
            gameView.printGallows(gameService.hangmanStageModel());
            gameView.gameLossOutput(gameSession.word());
        }
        gameService.changeStatusGameSession(gameSession);
        gameService.addGameInStatistic(gameSession);
    }

    public void processCommand(CommandInGameEnum command) {
        switch (command) {
            case GET_HINT: {
                gameView.printHint(gameService.wordToGuess());
                break;
            }

            case EXIT: {
                exit();
                break;
            }

            case MENU: {
                gameView.returnOutput();
                gameService.changeActiveGameShutdown();
                break;
            }

            default: {
                gameView.printUnknownCommand();
            }

        }
    }

    public void displayGameStatus() {
        gameView.printGallows(gameService.hangmanStageModel());
        gameView.printGameLineWithDashes(gameService.getWordWithGuessedLetters());
        gameView.printListOfLettersUsed(gameService.wordCollectorModel().getLetters());
        gameView.printAllCommands(gameService.getStringAboutAllCommands());
    }

    private void addAttemptGameSession(GameSession gameSession) {
        gameSession.attempt(gameSession.attempt() + 1);
    }

    private void exit() {
        gameView.goodbyeOutput();
        System.exit(0);
    }

    public String input() {
        try {
            return userInputStream.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
