package backend.academy.hangman.Controller;

import backend.academy.hangman.Model.StatisticsModel;
import backend.academy.hangman.View.StatisticsView;
import com.google.inject.Inject;

public class GameStatisticsController {
    private final StatisticsModel statisticsModel;
    private final StatisticsView statisticsView;

    @Inject
    public GameStatisticsController(StatisticsModel statisticsModel, StatisticsView statisticsView) {
        this.statisticsModel = statisticsModel;
        this.statisticsView = statisticsView;
    }

    public void displayStatistics() {
        statisticsView.displayStatistics(statisticsModel.getAllInfoStatistics());
    }
}
