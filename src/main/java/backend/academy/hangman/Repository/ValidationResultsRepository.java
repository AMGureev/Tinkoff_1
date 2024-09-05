package backend.academy.hangman.Repository;

import backend.academy.hangman.Entity.ValidatorErrorEntity;

public interface ValidationResultsRepository {
    public void addResults(ValidatorErrorEntity validatorErrorEntity);
}
