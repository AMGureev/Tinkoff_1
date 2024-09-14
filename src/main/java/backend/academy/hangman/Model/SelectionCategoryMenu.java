package backend.academy.hangman.Model;

import backend.academy.hangman.Controller.DictionaryController;
import backend.academy.hangman.Entity.WordEntity;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.Scanner;

@NoArgsConstructor
public class SelectionCategoryMenu {
    private final DictionaryController dictionary = new DictionaryController();

    public void viewCategory() {
        List<String> types = dictionary.getTypes();
        for (int i = 0; i < types.size(); i++) {
            System.out.println(i + ". " + types.get(i));
        }
        System.out.println("Other integer. random" );
        System.out.print("Please select a category: ");
    }

    public int input() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.println("Error: enter an integer.");
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
