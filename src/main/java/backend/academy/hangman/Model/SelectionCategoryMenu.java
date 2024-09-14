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
    private static final Logger logger = LogManager.getLogger(SelectionCategoryMenu.class);

    private final DictionaryController dictionary = new DictionaryController();

    public void viewCategory() {
        List<String> types = dictionary.getTypes();
        for (int i = 0; i < types.size(); i++) {
            logger.info("{}. {}", i, types.get(i));
        }
        logger.info("Other integer. random");
        logger.info("Please select a category: ");
    }

    public int input() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            logger.error("Error: enter an integer.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public WordEntity getRandomWordByCategoryAndLevel(int category, int level) {
        if (category >= dictionary.getTypes().size()) {
            return dictionary.getWordByLevel("random", level);
        }
        return dictionary.getWordByLevel(dictionary.getTypes().get(category), level);
    }

}
