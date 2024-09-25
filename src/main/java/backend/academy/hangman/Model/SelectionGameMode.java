package backend.academy.hangman.Model;

import backend.academy.hangman.Entity.DifficultyLevelEnum;
import backend.academy.hangman.Entity.WordEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SelectionGameMode {
    private final String random = "random";

    @Getter private final Dictionary dictionary = new Dictionary("hangman.txt");

    public DifficultyLevelEnum getLevel(int level) {
        if (level == 1) {
            return DifficultyLevelEnum.EASY;
        }
        return DifficultyLevelEnum.HARD;
    }

    public String getCategory(int choice) {
        if (choice >= dictionary.getTypes().size()) {
            return random;
        }
        return dictionary.getTypes().get(choice);
    }

    public WordEntity getRandomWordByCategoryAndLevel(int category, int level) {
        if (category >= dictionary.getTypes().size()) {
            return dictionary.getWordByLevel(random, getLevel(level));
        }
        return dictionary.getWordByLevel(getCategory(category), getLevel(level));
    }

}
