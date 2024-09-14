package backend.academy.hangman.Controller;

import backend.academy.hangman.Entity.ValidatorErrorEntity;
import backend.academy.hangman.Model.CommandValidator;
import backend.academy.hangman.Model.LetterValidator;
import backend.academy.hangman.Model.ValidationResultsModel;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ValidatorController {

    private final LetterValidator letterValidator = new LetterValidator();
    private final CommandValidator commandValidator = new CommandValidator();
    private final ValidationResultsModel validationResults;

    public boolean checkInput(String input) {
        if (letterValidator.isValid(input) != null) {
            validationResults.addResults(letterValidator.isValid(input));
            return false;
        }
        if (commandValidator.isValid(input) != null) {
            validationResults.addResults(commandValidator.isValid(input));
            return false;
        }
        return true;
    }

    public ValidatorErrorEntity getLast() {
        return validationResults.getLast();
    }
}
