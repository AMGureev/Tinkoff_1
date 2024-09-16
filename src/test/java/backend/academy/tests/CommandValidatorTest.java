package backend.academy.tests;

import backend.academy.hangman.Entity.ValidatorErrorEntity;
import backend.academy.hangman.Model.CommandValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CommandValidatorTest {

    private CommandValidator commandValidator;

    @BeforeEach
    public void setUp() {
        commandValidator = new CommandValidator();
    }

    @Test
    public void testValidSingleCharacterInput() {
        String input = "a";
        ValidatorErrorEntity result = commandValidator.isValid(input);
        assertNull(result, "Single character input should be valid");
    }

    @Test
    public void testValidCommandInput() {
        String input = "get hint";
        ValidatorErrorEntity result = commandValidator.isValid(input);
        assertNull(result, "Command 'get hint' should be valid");
    }

    @Test
    public void testInvalidCommandInput() {
        String input = "invalid command";
        ValidatorErrorEntity result = commandValidator.isValid(input);
        assertNotNull(result, "Invalid command should return a ValidatorErrorEntity");
        assertEquals("Error: entered the wrong command.", result.message());
    }

    @Test
    public void testExitCommand() {
        String input = "exit";
        ValidatorErrorEntity result = commandValidator.isValid(input);
        assertNull(result, "'exit' should be a valid command");
    }

    @Test
    public void testMenuCommand() {
        String input = "menu";
        ValidatorErrorEntity result = commandValidator.isValid(input);
        assertNull(result, "'menu' should be a valid command");
    }

    @Test
    public void testInvalidSingleCharacter() {
        String input = "";
        ValidatorErrorEntity result = commandValidator.isValid(input);
        assertNotNull(result, "Empty input should return a ValidatorErrorEntity");
        assertEquals("Error: entered the wrong command.", result.message());
    }

    @Test
    public void testInvalidMultiCharacterInput() {
        String input = "hello";
        ValidatorErrorEntity result = commandValidator.isValid(input);
        assertNotNull(result, "Input 'hello' should return a ValidatorErrorEntity");
        assertEquals("Error: entered the wrong command.", result.message());
    }
}
