package backend.academy.tests;

import backend.academy.hangman.Entity.WordEntity;
import backend.academy.hangman.Model.Dictionary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DictionaryTest {

    private Dictionary dictionary;

    @BeforeEach
    public void setUp() {
        dictionary = new Dictionary();
        dictionary.loadWordsFromFile("src/test/resources/test_words.txt");
    }

    @Test
    public void testLoadWordsFromFile() {
        List<WordEntity> words = dictionary.words();
        assertFalse(words.isEmpty(), "Words should be loaded");
        assertEquals(6, words.size(), "Expected 6 words in the test file");

        WordEntity word1 = words.getFirst();
        assertEquals("fruit", word1.type());
        assertEquals("apple", word1.word());
        assertEquals("A common fruit", word1.hint());
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
        WordEntity word = dictionary.getWordByLevel("fruit", 1);
        assertNotNull(word);
        assertTrue(word.word().length() <= 6);
    }

    @Test
    public void testGetWordByLevel_Level2() {
        WordEntity word = dictionary.getWordByLevel("animal", 2);
        assertNotNull(word);
        assertTrue(word.word().length() >= 5);
    }

    @Test
    public void testGetRandomWordByCategory() {
        WordEntity word = dictionary.getWordByLevel("random", 1);
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
        assertNull(filteredWords);
    }
}
