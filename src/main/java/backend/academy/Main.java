package backend.academy;

import backend.academy.hangman.AppModule;
import backend.academy.hangman.Controller.StartMenuController;
import com.google.inject.Guice;
import com.google.inject.Injector;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Main {
    @Setter @Getter public static Injector injector = Guice.createInjector(new AppModule());

    public static void main(String[] args) {
        StartMenuController controller = injector.getInstance(StartMenuController.class);
        controller.start();
    }
}
