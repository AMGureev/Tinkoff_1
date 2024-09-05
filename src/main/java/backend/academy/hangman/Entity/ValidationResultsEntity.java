package backend.academy.hangman.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ValidationResultsEntity {
    private List<ValidatorErrorEntity> errors;
}
