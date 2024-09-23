package backend.academy.hangman.Model;

import backend.academy.hangman.Controller.DictionaryController;
import backend.academy.hangman.Entity.WordEntity;
import java.util.List;
import java.util.Scanner;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@NoArgsConstructor
public class SelectionCategoryMenu {
    private static final Logger LOGGER = LogManager.getLogger(SelectionCategoryMenu.class);

    private final String random = "random";

    private final DictionaryController dictionary = new DictionaryController("hangman.txt");

    public void viewCategory() {
        List<String> types = dictionary.getTypes();
        for (int i = 0; i < types.size(); i++) {
            LOGGER.info("[{}] {}", i, types.get(i));
        }
        LOGGER.info("[OTHER] random");
        LOGGER.info("Please select a category: ");
    }

    public String getLevel(int level) {
        if (level == 1) {
            return "EASY";
        }
        return "HARD";
    }

    public String getCategory(int choice) {
        if (choice >= dictionary.getTypes().size()) {
            return random;
        }
        return dictionary.getTypes().get(choice);
    }

    public int input() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            LOGGER.error("Error: enter an integer.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public WordEntity getRandomWordByCategoryAndLevel(int category, int level) {
        if (category >= dictionary.getTypes().size()) {
            return dictionary.getWordByLevel(random, level);
        }
        return dictionary.getWordByLevel(dictionary.getTypes().get(category), level);
    }

}
