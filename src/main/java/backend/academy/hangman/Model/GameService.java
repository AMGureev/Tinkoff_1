package backend.academy.hangman.Model;

import backend.academy.hangman.Controller.ValidatorController;
import backend.academy.hangman.Entity.CommandInGameEnum;
import backend.academy.hangman.Entity.ResultGameEnum;
import backend.academy.hangman.Entity.WordEntity;
import com.google.inject.Inject;
import java.util.Objects;
import lombok.Getter;

public class GameService {
    @Getter
    private final WordEntity wordToGuess;
    private final StatisticsModel statistics;
    @Getter
    private ResultGameEnum resultOfGame;
    @Getter
    private HangmanStagesModel hangmanStageModel;
    @Getter
    private boolean isActiveGame = true;
    @Getter
    private final ValidatorController validator;
    @Getter
    private final WordCollectorModel wordCollectorModel;

    @Inject
    public GameService(WordEntity wordToGuess,
                       StatisticsModel statistics,
                       ValidatorController validator,
                       WordCollectorModel wordCollectorModel) {
        this.wordToGuess = wordToGuess;
        this.statistics = statistics;
        this.resultOfGame = ResultGameEnum.IN_PROGRESS;
        this.hangmanStageModel = HangmanStagesModel.STAGE_1;
        this.validator = validator;
        this.wordCollectorModel = wordCollectorModel;
    }

    public boolean isGameOver() {
        return (Objects.equals(hangmanStageModel.value(), HangmanStagesModel.STAGE_7.value())
                || Objects.equals(resultOfGame.valueResult(), ResultGameEnum.WIN.valueResult())
                || !isActiveGame);
    }

    public boolean isCommand(String inputString) {
        return CommandInGameEnum.isCommandValid(inputString);
    }

    public boolean isErrorThrown(String inputString) {
        return !validator.checkInput(inputString);
    }

    public boolean checkingEnteredLetter(char userLetter) {
        return wordCollectorModel.getLetters().contains(userLetter);
    }

    public void addLetterToWordCollectorModel(char userLetter) {
        wordCollectorModel.addLetter(userLetter);
    }

    public void checkingWhetherWordCollected(char userLetter) {
        if (wordToGuess.word().contains(String.valueOf(userLetter))) {
            if (isWordGuessed()) {
                resultOfGame = ResultGameEnum.WIN;
            }
        } else {
            hangmanStageModel = hangmanStageModel.nextStage();
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

    public void addGameInStatistic(GameSession gameSession) {
        statistics.addGameInStatistic(gameSession);
    }

    public void changeStatusGameSession(GameSession gameSession) {
        gameSession.status(resultOfGame.valueResult());
    }

    public void changeResultOfGame(ResultGameEnum resultOfGame) {
        this.resultOfGame = resultOfGame;
    }

    public void changeActiveGameShutdown() {
        this.isActiveGame = false;
    }

    public String getWordWithGuessedLetters() {
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

    public String getStringAboutAllCommands() {
        return CommandInGameEnum.getStringAboutAllCommands();
    }
}

