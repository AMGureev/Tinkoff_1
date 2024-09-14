package backend.academy.hangman.Model;

import backend.academy.hangman.Entity.ValidatorErrorEntity;
import backend.academy.hangman.Repository.ValidationResultsRepository;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Getter
public class ValidationResultsModel implements ValidationResultsRepository {
    private final List<ValidatorErrorEntity> errors = new ArrayList<>();

    @Override
    public void addResults(ValidatorErrorEntity validatorErrorEntity) {
        errors().add(validatorErrorEntity);
    }

    @Override
    public ValidatorErrorEntity getLast() {
        return errors().getLast();
    }

}
