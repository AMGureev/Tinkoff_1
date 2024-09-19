package backend.academy.hangman.Model;

import backend.academy.hangman.Entity.WordEntity;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Getter
@NoArgsConstructor
public class Dictionary {
    private static final int MAX_LENGTH_LEVEL_1 = 5;
    private static final int MIN_LENGTH_OTHER_LEVELS = 6;
    private static final Logger LOGGER = LogManager.getLogger(Dictionary.class);

    private final List<WordEntity> words = new ArrayList<>();
    private final Random random = new Random();

    public void loadWordsFromFile(String filePath) {
        final int length = 3;
        File file = new File(filePath);
        if (!file.exists()) {
            LOGGER.error("Error: the file does not exist. [SelectionCategoryMenu, when create new DictionaryController]");
            System.exit(0);
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == length) {
                    WordEntity wordEntity = new WordEntity(parts[1], parts[0], parts[2]);
                    words.add(wordEntity);
                }
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }

    public List<String> getTypes() {
        Set<String> types = new HashSet<>();
        for (WordEntity word : words) {
            types.add(word.type());
        }
        return new ArrayList<>(types);
    }

    public WordEntity getWordByLevel(String category, int level) {
        List<WordEntity> filteredWords;
        if (Objects.equals(category, "random")) {
            filteredWords = words;
        } else {
            filteredWords = getFilteredDictionary(category);
        }
        int minLength = 0;
        int maxLength = Integer.MAX_VALUE;
        if (level == 1) {
            maxLength = MAX_LENGTH_LEVEL_1;
        } else {
            minLength = MIN_LENGTH_OTHER_LEVELS;
        }
        int finalMinLength = minLength;
        int finalMaxLength = maxLength;
        List<WordEntity> wordsByLevel = filteredWords.stream()
            .filter(word -> word.word().length() >= finalMinLength && word.word().length() <= finalMaxLength)
            .toList();

        if (wordsByLevel.isEmpty()) {
            return null;
        }
        return wordsByLevel.get(random.nextInt(wordsByLevel.size()));
    }

    public List<WordEntity> getFilteredDictionary(String category) {
        List<WordEntity> filteredWords = words.stream()
            .filter(word -> word.type().equalsIgnoreCase(category))
            .toList();

        if (filteredWords.isEmpty()) {
            return null;
        }
        return filteredWords;
    }
}
