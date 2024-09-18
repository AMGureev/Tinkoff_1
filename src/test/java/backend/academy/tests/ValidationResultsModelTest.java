package backend.academy.tests;

import backend.academy.hangman.Entity.ValidatorErrorEntity;
import backend.academy.hangman.Model.ValidationResultsModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidationResultsModelTest {

    private ValidationResultsModel validationResultsModel;

    @BeforeEach
    public void setUp() {
        validationResultsModel = new ValidationResultsModel();
    }

    @Test
    public void testAddResults() {
        ValidatorErrorEntity error = new ValidatorErrorEntity("Error 1");

        validationResultsModel.addResults(error);

        assertEquals(1, validationResultsModel.errors().size());
        assertEquals("Error 1", validationResultsModel.errors().getFirst().message());
    }

    @Test
    public void testGetLast() {
        ValidatorErrorEntity error1 = new ValidatorErrorEntity("Error 1");
        ValidatorErrorEntity error2 = new ValidatorErrorEntity("Error 2");

        validationResultsModel.addResults(error1);
        validationResultsModel.addResults(error2);

        ValidatorErrorEntity lastError = validationResultsModel.getLast();
        assertEquals("Error 2", lastError.message());
    }
}
