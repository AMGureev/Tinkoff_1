package backend.academy.tests;

import backend.academy.hangman.Controller.DictionaryController;
import backend.academy.hangman.Entity.WordEntity;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class DictionaryControllerTest {

    private DictionaryController dictionaryController;

    @BeforeEach
    public void setUp() {
        dictionaryController = new DictionaryController("test_words.txt");
    }

    @Test
    public void testReadFile() {
        List<String> types = dictionaryController.getTypes();

        assertThat(types).isNotNull();
        assertThat(types).isNotEmpty();
        assertThat(types).contains("animal", "fruit");
    }

    @Test
    public void testGetWordByLevel_ValidCategoryAndLevel_2() {
        WordEntity word = dictionaryController.getWordByLevel("animal", 2);

        assertThat(word).isNotNull();
        assertThat(word.word()).isEqualTo("elephant");
        assertThat(word.hint()).isEqualTo("a large animal with a trunk");
    }

    @Test
    public void testGetWordByLevel_ValidCategoryAndLevel_1() {
        WordEntity word = dictionaryController.getWordByLevel("animal", 1);

        assertThat(word).isNotNull();
        assertThat(word.word()).isEqualTo("tiger");
        assertThat(word.hint()).isEqualTo("a large wild cat");
    }
}
