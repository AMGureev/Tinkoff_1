package backend.academy.tests;

import backend.academy.hangman.Entity.WordCollectorEntity;
import backend.academy.hangman.Model.WordCollectorModel;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCollectorModelTest {

    private WordCollectorModel wordCollectorModel;

    @BeforeEach
    public void setUp() {
        WordCollectorEntity wordCollectorEntity = new WordCollectorEntity();
        wordCollectorModel = new WordCollectorModel(wordCollectorEntity);
    }

    @Test
    public void testAddLetterNewLetter() {
        char letter = 'a';
        wordCollectorModel.addLetter(letter);

        List<Character> letters = wordCollectorModel.getLetters();
        assertEquals(1, letters.size());
        assertEquals(Character.valueOf(letter), letters.getFirst());
    }

    @Test
    public void testAddLetterDuplicate() {
        char letter = 'a';
        wordCollectorModel.addLetter(letter);

        wordCollectorModel.addLetter(letter);

        List<Character> letters = wordCollectorModel.getLetters();
        assertEquals(1, letters.size());
        assertEquals(Character.valueOf(letter), letters.getFirst());
    }

    @Test
    public void testGetLetters() {
        wordCollectorModel.addLetter('a');
        wordCollectorModel.addLetter('b');

        List<Character> letters = wordCollectorModel.getLetters();
        assertEquals(2, letters.size());
        assertEquals(List.of('a', 'b'), letters);
    }
}
