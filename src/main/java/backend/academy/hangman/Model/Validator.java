package backend.academy.hangman.Model;

import backend.academy.hangman.Entity.ValidatorErrorEntity;

public interface Validator {
    ValidatorErrorEntity isValid(String input);
}
