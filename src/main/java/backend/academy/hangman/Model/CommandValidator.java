package backend.academy.hangman.Model;

import backend.academy.hangman.Entity.ValidatorErrorEntity;
import java.util.List;

public class CommandValidator implements Validator {
    private final static List<String> list = List.of("get hint", "exit", "menu");
    public ValidatorErrorEntity isValid(String input) {
        if (input.length() == 1 || list.contains(input)) {
            return null;
        }
        return new ValidatorErrorEntity("Error: entered the wrong command.");
    }
}
