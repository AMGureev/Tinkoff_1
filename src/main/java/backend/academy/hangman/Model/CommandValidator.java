package backend.academy.hangman.Model;

import backend.academy.hangman.Entity.ValidatorErrorEntity;
import backend.academy.hangman.Repository.Validator;
import java.util.List;

public class CommandValidator implements Validator {
    private final static List<String> COMMAND_LIST = List.of("get hint", "exit", "menu");

    public ValidatorErrorEntity isValid(String input) {
        if (input.length() == 1 || COMMAND_LIST.contains(input)) {
            return null;
        }
        return new ValidatorErrorEntity("Error: entered the wrong command.");
    }
}
