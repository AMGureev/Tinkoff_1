package backend.academy.hangman.Model;

import backend.academy.hangman.Entity.ValidatorErrorEntity;

public class LetterValidator implements Validator {
    @Override
    public ValidatorErrorEntity isValid(String input) {
        if (input.length() == 1) {
            if (!Character.isLetter(input.charAt(0))) {
                return new ValidatorErrorEntity("Ошибка: пользователь ввел не букву!");
            }
            return null;
        }
        return new ValidatorErrorEntity("Ошибка: пользователь ввел длинное слово!");
    }
}
