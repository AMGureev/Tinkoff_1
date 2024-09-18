package backend.academy.hangman.Controller;

import backend.academy.hangman.Entity.WordEntity;
import backend.academy.hangman.Model.Dictionary;
import java.util.List;

public class DictionaryController {
    private final Dictionary dictionary = new Dictionary();

    public DictionaryController(String link) {
        readFile(link);
    }

    public void readFile(String link) {
        dictionary.loadWordsFromFile(link);
    }

    public List<String> getTypes() {
        return dictionary.getTypes();
    }

    public WordEntity getWordByLevel(String category, int level) {
        return dictionary.getWordByLevel(category, level);
    }
}
