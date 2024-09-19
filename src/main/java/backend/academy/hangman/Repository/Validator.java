package backend.academy.hangman.Repository;

import backend.academy.hangman.Entity.ValidatorErrorEntity;

public interface Validator {
    ValidatorErrorEntity isValid(String input);
}
