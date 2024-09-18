package backend.academy.hangman.Controller;

import backend.academy.hangman.Entity.WordCollectorEntity;
import backend.academy.hangman.Entity.WordEntity;
import backend.academy.hangman.Model.GameSession;
import backend.academy.hangman.Model.HangmanStagesModel;
import backend.academy.hangman.Model.StatisticsModel;
import backend.academy.hangman.Model.ValidationResultsModel;
import backend.academy.hangman.Model.WordCollectorModel;
import backend.academy.hangman.View.GameView;
import com.google.inject.Inject;
import java.util.Objects;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GameController {
    private static final Logger LOGGER = LogManager.getLogger(GameController.class);
    private HangmanStagesModel hangmanStageEntity;
    private final ValidatorController validator = new ValidatorController(new ValidationResultsModel());
    private final WordEntity wordToGuess;
    private final WordCollectorModel wordCollectorModel = new WordCollectorModel(new WordCollectorEntity());
    private final StatisticsModel statistics;
    private final GameView view;
    private boolean gameWon;
    private boolean game = true;

    @Inject
    public GameController(
        WordEntity wordToGuess,
        StatisticsModel statistics,
        GameView view
    ) {
        this.view = view;
        this.hangmanStageEntity = HangmanStagesModel.STAGE_1;
        this.wordToGuess = wordToGuess;
        this.gameWon = false;
        this.statistics = statistics;
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        view.greetingOutput();
        GameSession gameSession = new GameSession(wordToGuess.word());
        printWordType();
        while (!Objects.equals(hangmanStageEntity.value(), HangmanStagesModel.STAGE_7.value()) && !gameWon && game) {
            displayGameStatus();
            String input = scanner.nextLine().toLowerCase();
            processInput(input);
            addAttemptGameSession(gameSession);
        }
        if (!game) {
            return;
        } else {
            if (gameWon) {
                view.gameWonOutput(wordToGuess.word());
                changeStatusGameSession(gameSession, "win");
            } else {
                printGallows();
                view.gameLossOutput(wordToGuess.word());
                changeStatusGameSession(gameSession, "defeat");
            }
        }
        statistics.addGame(gameSession);
    }

    private void processInput(String input) {
        switch (input) {
            case "get hint":
                view.printHint(wordToGuess);
                break;

            case "exit":
                exit();
                break;

            case "menu":
                view.returnOutput();
                this.game = false;
                break;

            default:
                if (!validator.checkInput(input)) {
                    LOGGER.info(validator.getLast().message());
                    break;
                }
                if (wordCollectorModel.getLetters().contains(input.charAt(0))) {
                    view.printWarning();
                    break;
                }
                wordCollectorModel.addLetter(input.charAt(0));
                if (wordToGuess.word().contains(input)) {
                    if (isWordGuessed()) {
                        gameWon = true;
                    }
                } else {
                    hangmanStageEntity = hangmanStageEntity.nextStage();
                }
                break;
        }
    }

    private boolean isWordGuessed() {
        for (int i = 0; i < wordToGuess.word().length(); i++) {
            if (!wordCollectorModel.getLetters().contains(wordToGuess.word().charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private void displayGameStatus() {
        printGallows();
        LOGGER.info("Word: {}", getWordWithGuessedLetters());
        LOGGER.info("Guessed letters: {}", wordCollectorModel.getLetters());
        LOGGER.info("Enter a letter or a command ('get hint', 'exit', 'menu'):");
    }

    private String getWordWithGuessedLetters() {
        StringBuilder wordBuilder = new StringBuilder();
        for (int i = 0; i < wordToGuess.word().length(); i++) {
            if (wordCollectorModel.getLetters().contains(wordToGuess.word().charAt(i))) {
                wordBuilder.append(wordToGuess.word().charAt(i));
            } else {
                wordBuilder.append('_');
            }
        }
        return wordBuilder.toString();
    }

    private void printGallows() {
        LOGGER.info(hangmanStageEntity.value());
    }

    private void printWordType() {
        view.printWordType(wordToGuess.type());
    }

    private void changeStatusGameSession(GameSession gameSession, String status) {
        gameSession.status(status);
    }

    private void addAttemptGameSession(GameSession gameSession) {
        gameSession.attempt(gameSession.attempt() + 1);
    }

    private void exit() {
        view.goodbyeOutput();
        System.exit(0);
    }
}
