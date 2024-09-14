package backend.academy.hangman.Controller;

import backend.academy.Main;
import backend.academy.hangman.Entity.WordEntity;
import backend.academy.hangman.Model.SelectionCategoryMenu;
import backend.academy.hangman.Model.StatisticsModel;
import backend.academy.hangman.View.GameView;
import backend.academy.hangman.View.SelectionCategoryMenuView;
import com.google.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SelectionStagesMenuController {
    private static final Logger LOGGER = LogManager.getLogger(SelectionStagesMenuController.class);
    private final SelectionCategoryMenu model;
    private final SelectionCategoryMenuView view;

    @Inject
    public SelectionStagesMenuController(
        SelectionCategoryMenu model,
        SelectionCategoryMenuView view
    ) {
        this.model = model;
        this.view = view;
    }

    public void chooseCategory() {
        view.printHeading();
        model.viewCategory();
        int choice;
        choice = model.input();
        chooseLevel(choice);
    }

    public void chooseLevel(Integer choice) {
        view.displaySetLevel();
        int level = model.input();
        WordEntity word = model.getRandomWordByCategoryAndLevel(choice, level);
        if (word != null) {
            GameController controller = new GameController(word, Main.injector.getInstance(StatisticsModel.class),
                Main.injector.getInstance(GameView.class));
            controller.startGame();
        } else {
            LOGGER.error("Error: there are no words of such complexity.");
        }
    }

}
