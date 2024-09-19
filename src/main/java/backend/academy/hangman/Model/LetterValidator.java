package backend.academy.hangman.Model;

import backend.academy.hangman.Entity.ValidatorErrorEntity;
import backend.academy.hangman.Repository.Validator;

public class LetterValidator implements Validator {
    @Override
    public ValidatorErrorEntity isValid(String input) {
        if (input.isEmpty()) {
            return new ValidatorErrorEntity("Error: enter an integer.");
        }
        if (input.length() == 1) {
            if (!Character.isLetter(input.charAt(0))) {
                return new ValidatorErrorEntity("Error: the user entered the wrong letter.");
            }
        }
        return null;
    }
}
