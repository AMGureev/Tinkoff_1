package backend.academy;

import backend.academy.hangman.AppModule;
import backend.academy.hangman.Controller.StartMenuController;
import com.google.inject.Guice;
import com.google.inject.Injector;
import lombok.Getter;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Main {
    @Getter public static Injector injector;

    public static void main(String[] args) {
        injector = Guice.createInjector(new AppModule());
        StartMenuController controller = injector.getInstance(StartMenuController.class);
        controller.start();
    }
}
