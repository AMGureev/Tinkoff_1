package backend.academy.hangman.Repository;

import backend.academy.hangman.Entity.ValidatorErrorEntity;

public interface ValidationResultsRepository {
    void addResults(ValidatorErrorEntity validatorErrorEntity);

    ValidatorErrorEntity getLast();
}
