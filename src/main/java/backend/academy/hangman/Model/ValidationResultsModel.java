package backend.academy.hangman.Model;

import backend.academy.hangman.Entity.ValidationResultsEntity;
import backend.academy.hangman.Entity.ValidatorErrorEntity;
import backend.academy.hangman.Repository.ValidationResultsRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ValidationResultsModel implements ValidationResultsRepository {
    private final ValidationResultsEntity validationResultsEntity;

    @Override
    public void addResults(ValidatorErrorEntity validatorErrorEntity) {
        validationResultsEntity.errors().add(validatorErrorEntity);
    }
}
