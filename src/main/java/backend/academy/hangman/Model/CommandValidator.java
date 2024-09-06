package backend.academy.hangman.Model;

import backend.academy.hangman.Entity.ValidatorErrorEntity;
import java.util.List;

public class CommandValidator implements Validator {
    private final static List<String> list = List.of("get hint", "exit", "menu");
    public ValidatorErrorEntity isValid(String input) {
        if (!list.contains((Object) input)) {
            return new ValidatorErrorEntity("Ошибка: пользователь ввел не команду!");
        }
        return null;
    }
}
