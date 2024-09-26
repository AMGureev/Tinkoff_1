package backend.academy.hangman.Controller;

import backend.academy.hangman.Model.StartMenu;
import backend.academy.hangman.View.StartMenuView;
import com.google.inject.Inject;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StartMenuController {
    private final StartMenuView startMenuView;
    private final StartMenu startMenuModel;
    private final GameStatisticsController statisticsController;
    private final SelectionGameModeController gameModeController;
    private BufferedReader userInputStream;
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
        userInputStream = new BufferedReader(new InputStreamReader(System.in));

        startMenuView.displayStartMenu();
        startMenuView.displaySelect();
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
                    displayInputError();
            }
            startMenuView.displaySelect();
            choice = inputChoice();
        }
        exitProgram();
    }

    public void displayUserStatistics() {
        statisticsController.displayStatistics();
    }

    public void startGame() {
        gameModeController.settingUpTheGame();
    }

    public void exitProgram() {
        startMenuView.displayGoodbye();
        startMenuModel.exit();
    }

    public int inputChoice() {
        String inputString = "";
        int userChoice = 0;
        while (!inputString.matches("-?\\d+")) {
            try {
                inputString = userInputStream.readLine();
                userChoice = Integer.parseInt(inputString);
            } catch (Exception e) {
                startMenuView.displayError();
            }
        }
        return userChoice;
    }

    public void displayInputError() {
        startMenuView.displayError();
    }
}
