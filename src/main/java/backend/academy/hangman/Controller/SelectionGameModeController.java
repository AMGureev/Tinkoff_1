package backend.academy.hangman.Controller;

import backend.academy.Main;
import backend.academy.hangman.Entity.WordCollectorEntity;
import backend.academy.hangman.Entity.WordEntity;
import backend.academy.hangman.Model.GameService;
import backend.academy.hangman.Model.SelectionGameMode;
import backend.academy.hangman.Model.StatisticsModel;
import backend.academy.hangman.Model.ValidationResultsModel;
import backend.academy.hangman.Model.WordCollectorModel;
import backend.academy.hangman.View.GameView;
import backend.academy.hangman.View.SelectionGameModeView;
import com.google.inject.Inject;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SelectionGameModeController {
    private final SelectionGameMode gameModeModel;
    private final SelectionGameModeView selectionGameModeView;
    private BufferedReader userInputStream;

    @Inject
    public SelectionGameModeController(
        SelectionGameMode gameModeModel,
        SelectionGameModeView selectionGameModeView
    ) {
        this.gameModeModel = gameModeModel;
        this.selectionGameModeView = selectionGameModeView;
    }

    public void settingUpTheGame() {
        userInputStream = new BufferedReader(new InputStreamReader(System.in));

        selectionGameModeView.printHeading();
        selectionGameModeView.viewCategory(gameModeModel);

        int selectedCategory = input();

        selectionGameModeView.printChoiceCategory(
            gameModeModel.getCategory(selectedCategory));

        selectionGameModeView.displaySetLevel();

        int selectedLevel = input();

        selectionGameModeView.printChoiceLevel(
            gameModeModel.getLevel(selectedLevel).valueLevel());

        startGame(gameModeModel.getRandomWordByCategoryAndLevel(selectedCategory, selectedLevel));

    }

    public void startGame(WordEntity word) {
        if (word != null) {
            GameService gameService = new GameService(word,
                Main.injector.getInstance(StatisticsModel.class),
                new ValidatorController(new ValidationResultsModel()),
                new WordCollectorModel(new WordCollectorEntity()));
            GameController gameController = new GameController(
                gameService,
                Main.injector.getInstance(GameView.class));
            gameController.startGame();
        } else {
            selectionGameModeView.printErrorWordNotFound();
        }
    }

    public int input() {
        String inputString = "";
        int userChoice = 0;
        while (!inputString.matches("-?\\d+")) {
            try {
                inputString = userInputStream.readLine();
                userChoice = Integer.parseInt(inputString);
            } catch (Exception e) {
                selectionGameModeView.printInputError();
            }
        }
        return userChoice;
    }
}
