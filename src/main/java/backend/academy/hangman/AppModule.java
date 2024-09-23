package backend.academy.hangman;

import backend.academy.hangman.Controller.GameStatisticsController;
import backend.academy.hangman.Controller.SelectionGameModeController;
import backend.academy.hangman.Model.SelectionGameMode;
import backend.academy.hangman.Model.StartMenu;
import backend.academy.hangman.Model.StatisticsModel;
import backend.academy.hangman.View.GameView;
import backend.academy.hangman.View.SelectionCategoryMenuView;
import backend.academy.hangman.View.StartMenuView;
import backend.academy.hangman.View.StatisticsView;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class AppModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(StartMenuView.class).in(Singleton.class);
        bind(StartMenu.class).in(Singleton.class);
        bind(GameStatisticsController.class).in(Singleton.class);
        bind(SelectionGameModeController.class).in(Singleton.class);
        bind(SelectionGameMode.class).in(Singleton.class);
        bind(SelectionCategoryMenuView.class).in(Singleton.class);
        bind(StatisticsModel.class).in(Singleton.class);
        bind(StatisticsView.class).in(Singleton.class);
        bind(GameView.class).in(Singleton.class);
    }
}
