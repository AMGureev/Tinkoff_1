package backend.academy.hangman.Controller;

import backend.academy.hangman.Model.StartMenu;
import backend.academy.hangman.View.StartMenuView;
import com.google.inject.Inject;

public class StartMenuController {
    private final StartMenuView startMenuView;
    private final StartMenu startMenuModel;
    private final GameStatisticsController statisticsController;
    private final SelectionGameModeController gameModeController;
    private static final int EXIT_NUMBER = 3;

    @Inject
    public StartMenuController(
        StartMenuView startMenuView,
        StartMenu startMenuModel,
        GameStatisticsController statisticsController,
        SelectionGameModeController gameModeController
    ) {
        this.startMenuView = startMenuView;
        this.startMenuModel = startMenuModel;
        this.statisticsController = statisticsController;
        this.gameModeController = gameModeController;
    }

    public void start() {
        startMenuView.displayStartMenu();
        int choice = 0;
        choice = inputChoice();
        while (choice != EXIT_NUMBER) {
            switch (choice) {
                case 1:
                    startGame();
                    break;
                case 2:
                    displayUserStatistics();
                    break;
                default:
                    displayError();
            }
            choice = inputChoice();
        }
        exitProgram();
    }

    public void displayUserStatistics() {
        statisticsController.displayStatistics();
    }

    public void startGame() {
        gameModeController.chooseCategory();
    }

    public void exitProgram() {
        startMenuView.displayGoodbye();
        startMenuModel.exit();
    }

    public int inputChoice() {
        startMenuView.displaySelect();
        return startMenuModel.input();
    }

    public void displayError() {
        startMenuView.displayError();
    }
}
