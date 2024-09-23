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
        StartMenuView view,
        StartMenu model,
        GameStatisticsController statisticsController,
        SelectionGameModeController stagesMenu
    ) {
        this.startMenuView = view;
        this.startMenuModel = model;
        this.statisticsController = statisticsController;
        this.gameModeController = stagesMenu;
    }

    public void start() {
        startMenuView.displayStartMenu();
        int choice = 0;
        while (choice != DEFAULT_MAX_COUNT) {
            startMenuView.displaySelect();
            choice = startMenuModel.input();
            switch (choice) {
                case 1:
                    setGameMode();
                    break;
                case 2:
                    displayUserStatistics();
                    break;
                case DEFAULT_MAX_COUNT:
                    exitProgram();
                    break;
                default:
                    startMenuView.displayError();
            }
        }
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
}
