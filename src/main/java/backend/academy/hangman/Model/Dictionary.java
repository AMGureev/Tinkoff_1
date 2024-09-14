package backend.academy.hangman.Model;

import backend.academy.hangman.Entity.WordEntity;
import java.io.BufferedReader;
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

@Getter
@NoArgsConstructor
public class Dictionary {
    private final List<WordEntity> words = new ArrayList<>();
    private final Random random = new Random();

    public void loadWordsFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 3) {
                    WordEntity wordEntity = new WordEntity(parts[1], parts[0], parts[2]);
                    words.add(wordEntity);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
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
        int minLength;
        int maxLength;
        if (level == 1) {
            minLength = 0;
            maxLength = 6;
        } else {
            minLength = 5;
            maxLength = Integer.MAX_VALUE;
        }
        List<WordEntity> wordsByLevel = filteredWords.stream()
            .filter(word -> word.word().length() >= minLength && word.word().length() <= maxLength)
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
