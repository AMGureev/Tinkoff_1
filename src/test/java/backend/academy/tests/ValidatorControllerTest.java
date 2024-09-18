package backend.academy.tests;

import backend.academy.hangman.Controller.ValidatorController;
import backend.academy.hangman.Entity.ValidatorErrorEntity;
import backend.academy.hangman.Model.ValidationResultsModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ValidatorControllerTest {

    private ValidatorController validatorController;
    private ValidationResultsModel validationResults;

    @BeforeEach
    public void setUp() {
        validationResults = new ValidationResultsModel();
        validatorController = new ValidatorController(validationResults);
    }

    @Test
    public void testCheckInput_ValidLetter() {
        String validInput = "a";
        boolean isValid = validatorController.checkInput(validInput);

        assertThat(isValid).isTrue();
        assertThat(validationResults.errors().isEmpty());
    }

    @Test
    public void testCheckInput_InvalidLetter() {
        String invalidInput = "1";
        boolean isValid = validatorController.checkInput(invalidInput);

        assertThat(isValid).isFalse();
        ValidatorErrorEntity lastError = validatorController.getLast();
        assertThat(lastError).isNotNull();
        assertThat(lastError.message()).contains("Error: the user entered the wrong letter.");
    }

    @Test
    public void testCheckInput_ValidCommand() {
        String validCommand = "get hint";
        boolean isValid = validatorController.checkInput(validCommand);

        assertThat(isValid).isTrue();
        assertThat(validationResults.errors().isEmpty());
    }

    @Test
    public void testCheckInput_InvalidCommand() {
        String invalidCommand = "invalidCmd";
        boolean isValid = validatorController.checkInput(invalidCommand);

        assertThat(isValid).isFalse();
        ValidatorErrorEntity lastError = validatorController.getLast();
        assertThat(lastError).isNotNull();
        assertThat(lastError.message()).contains("Error: entered the wrong command.");
    }

    @Test
    public void testGetLast_AfterError() {
        String invalidInput = "1";
        validatorController.checkInput(invalidInput);

        ValidatorErrorEntity lastError = validatorController.getLast();
        assertThat(lastError).isNotNull();
        assertThat(lastError.message()).contains("Error: the user entered the wrong letter.");
    }
}
