package backend.academy.tests;

import backend.academy.hangman.Entity.ValidatorErrorEntity;
import backend.academy.hangman.Model.LetterValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LetterValidatorTest {

    private LetterValidator letterValidator;

    @BeforeEach
    public void setUp() {
        letterValidator = new LetterValidator();
    }

    @Test
    public void testEmptyInput() {
        ValidatorErrorEntity result = letterValidator.isValid("");
        assertNotNull(result);
        assertEquals("Error: enter an integer.", result.message());
    }

    @Test
    public void testSingleLetterInput() {
        ValidatorErrorEntity result = letterValidator.isValid("a");
        assertNull(result);
    }

    @Test
    public void testNonLetterCharacter() {
        ValidatorErrorEntity result = letterValidator.isValid("1");
        assertNotNull(result);
        assertEquals("Error: the user entered the wrong letter.", result.message());
    }

    @Test
    public void testMultipleCharacters() {
        ValidatorErrorEntity result = letterValidator.isValid("abc");
        assertNull(result);
    }
}
