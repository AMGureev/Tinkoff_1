package backend.academy.hangman.Controller;

import backend.academy.hangman.Model.StatisticsModel;
import backend.academy.hangman.View.StatisticsView;
import com.google.inject.Inject;

public class GameStatisticsController {
    private final StatisticsModel model;
    private final StatisticsView view;

    @Inject
    public GameStatisticsController(StatisticsModel model, StatisticsView view) {
        this.model = model;
        this.view = view;
    }

    public void displayStatistics() {
        view.displayStatistics(model.toString());
    }
}
