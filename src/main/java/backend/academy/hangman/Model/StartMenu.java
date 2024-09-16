package backend.academy.hangman.Model;

import java.util.Scanner;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@NoArgsConstructor
public class StartMenu {
    private static final Logger LOGGER = LogManager.getLogger(StartMenu.class);

    public int input() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            LOGGER.error("Error: enter an integer [1-3]");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public void exit() {
        System.exit(0);
    }
}
