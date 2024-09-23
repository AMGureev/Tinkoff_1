package backend.academy.hangman.Controller;

import backend.academy.hangman.Model.StartMenu;
import backend.academy.hangman.View.StartMenuView;
import com.google.inject.Inject;

public class StartMenuController {
    private final StartMenuView startMenuView;
    private final StartMenu startMenuModel;
    private final GameStatisticsController statisticsController;
    private final SelectionGameModeController gameModeController;
    private static final int DEFAULT_MAX_COUNT = 3;

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
        while (choice != DEFAULT_MAX_COUNT) {
            switch (choice) {
                case 1:
                    setGameMode();
                    break;
                case 2:
                    displayUserStatistics();
                    break;
                default:
                    startMenuView.displayError();
            }
            choice = inputChoice();
        }
        exitProgram();
    }

    public void displayUserStatistics() {
        statisticsController.displayStatistics();
    }

    public void setGameMode() {
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
}
