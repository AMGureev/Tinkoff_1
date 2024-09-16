package backend.academy.hangman.Controller;

import backend.academy.hangman.Model.StartMenu;
import backend.academy.hangman.View.StartMenuView;
import com.google.inject.Inject;

public class StartMenuController {
    private final StartMenuView view;
    private final StartMenu model;
    private final GameStatisticsController statisticsController;
    private final SelectionStagesMenuController stagesMenu;
    private static final int DEFAULT_MAX_COUNT = 3;

    @Inject
    public StartMenuController(
        StartMenuView view,
        StartMenu model,
        GameStatisticsController statisticsController,
        SelectionStagesMenuController stagesMenu
    ) {
        this.view = view;
        this.model = model;
        this.statisticsController = statisticsController;
        this.stagesMenu = stagesMenu;
    }

    public void start() {
        view.displayStartMenu();
        int choice = 0;
        while (choice != DEFAULT_MAX_COUNT) {
            view.displaySelect();
            choice = model.input();
            switch (choice) {
                case 1:
                    setCategoryMenu();
                    break;
                case 2:
                    displayUserStatistics();
                    break;
                case 3:
                    exitProgram();
                    break;
                default:
                    view.displayError();
            }
        }
    }

    public void displayUserStatistics() {
        statisticsController.displayStatistics();
    }

    public void setCategoryMenu() {
        stagesMenu.chooseCategory();
    }

    public void exitProgram() {
        view.displayGoodbye();
        model.exit();
    }
}
