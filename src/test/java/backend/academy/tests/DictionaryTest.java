package backend.academy.tests;

import backend.academy.hangman.Entity.DifficultyLevelEnum;
import backend.academy.hangman.Entity.WordEntity;
import backend.academy.hangman.Model.Dictionary;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DictionaryTest {

    private Dictionary dictionary;

    @BeforeEach
    public void setUp() {
        dictionary = new Dictionary("test_words.txt");
    }

    @Test
    public void testLoadWordsFromFile() {
        List<WordEntity> words = dictionary.words();
        assertFalse(words.isEmpty(), "Words should be loaded");
        assertEquals(4, words.size(), "Expected 4 words in the test file");

        WordEntity word1 = words.getFirst();
        assertEquals("fruit", word1.type());
        assertEquals("apple", word1.word());
    }

    @Test
    public void testGetTypes() {
        List<String> types = dictionary.getTypes();
        assertEquals(2, types.size());
        assertTrue(types.contains("fruit"));
        assertTrue(types.contains("animal"));
    }

    @Test
    public void testGetWordByLevel_Level1() {
        WordEntity word = dictionary.getWordByLevel("fruit", DifficultyLevelEnum.EASY);
        assertNotNull(word);
        assertTrue(word.word().length() <= 6);
    }

    @Test
    public void testGetWordByLevel_Level2() {
        WordEntity word = dictionary.getWordByLevel("animal", DifficultyLevelEnum.HARD);
        assertNotNull(word);
        assertTrue(word.word().length() >= 5);
    }

    @Test
    public void testGetRandomWordByCategory() {
        WordEntity word = dictionary.getWordByLevel("random", DifficultyLevelEnum.EASY);
        assertNotNull(word);
    }

    @Test
    public void testGetFilteredDictionary() {
        List<WordEntity> filteredWords = dictionary.getFilteredDictionary("fruit");
        assertNotNull(filteredWords);
        assertFalse(filteredWords.isEmpty());
        assertTrue(filteredWords.stream().allMatch(word -> word.type().equalsIgnoreCase("fruit")));
    }

    @Test
    public void testEmptyCategory() {
        List<WordEntity> filteredWords = dictionary.getFilteredDictionary("nonexistent");
        assertTrue(filteredWords.isEmpty());
    }
}
