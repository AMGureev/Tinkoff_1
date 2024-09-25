package backend.academy.hangman.Model;

import backend.academy.hangman.Entity.DifficultyLevelEnum;
import backend.academy.hangman.Entity.WordEntity;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Getter
public class Dictionary {
    private static final int MAX_LENGTH_LEVEL_EASY = 5;
    private static final int MIN_LENGTH_LEVEL_HARD = 6;
    private static final Logger LOGGER = LogManager.getLogger(Dictionary.class);

    private final List<WordEntity> words = new ArrayList<>();
    private final Random random = new Random();

    public Dictionary(String filePath) {
        loadWordsFromFile(filePath);
    }

    public void loadWordsFromFile(String filePath) {
        final int partsOfWordInformation = 3;
        File file = new File(filePath);
        if (!file.exists()) {
            LOGGER.error("Error: the file does not exist. "
                + "[SelectionCategoryMenu, when create new DictionaryController]");
            System.exit(0);
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == partsOfWordInformation) {
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

    public WordEntity getWordByLevel(String category, DifficultyLevelEnum level) {
        List<WordEntity> filteredWords;
        if (Objects.equals(category, "random")) {
            filteredWords = words;
        } else {
            filteredWords = getFilteredDictionary(category);
        }

        Set<Integer> lengthRange = defineWordLength(level);

        final int minLength = lengthRange.stream().min(Integer::compareTo).orElse(0);
        final int maxLength = lengthRange.stream().max(Integer::compareTo).orElse(Integer.MAX_VALUE);

        List<WordEntity> wordsByLevel = filteredWords.stream()
            .filter(word -> word.word().length() >= minLength && word.word().length() <= maxLength)
            .toList();

        if (wordsByLevel.isEmpty()) {
            return null;
        }

        return wordsByLevel.get(random.nextInt(wordsByLevel.size()));
    }

    public Set<Integer> defineWordLength(DifficultyLevelEnum level) {
        int minLength = 0;
        int maxLength = Integer.MAX_VALUE;
        switch (level) {
            case EASY: {
                maxLength = MAX_LENGTH_LEVEL_EASY;
                break;
            }
            case HARD: {
                minLength = MIN_LENGTH_LEVEL_HARD;
            }
        }
        return new HashSet<>(Arrays.asList(minLength, maxLength));
    }

    public List<WordEntity> getFilteredDictionary(String category) {

        return words.stream()
            .filter(word -> word.type().equalsIgnoreCase(category))
            .toList();
    }
}
