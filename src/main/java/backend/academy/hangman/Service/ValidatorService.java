package backend.academy.hangman.Service;

import backend.academy.hangman.Entity.ValidationResultsEntity;
import backend.academy.hangman.Model.CommandValidator;
import backend.academy.hangman.Model.LetterValidator;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ValidatorService {

    private final LetterValidator letterValidator;
    private final CommandValidator commandValidator;
    private final ValidationResultsEntity validationResults;

    public boolean checkInput(String input) {
        if (letterValidator.isValid(input) != null) {
            if (commandValidator.isValid(input) != null) {
                validationResults.errors().add(commandValidator.isValid(input));
            } else {
                validationResults.errors().add(letterValidator.isValid(input));
            }
            return false;
        }
        return true;
    }

}
