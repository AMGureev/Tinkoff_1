package backend.academy.hangman.Model;

import backend.academy.hangman.Entity.CommandInGameEnum;
import backend.academy.hangman.Entity.ValidatorErrorEntity;
import backend.academy.hangman.Repository.Validator;
import java.util.List;

public class CommandValidator implements Validator {
    private final static List<CommandInGameEnum> COMMAND_LIST = List.of(CommandInGameEnum.values());

    public ValidatorErrorEntity isValid(String userInput) {
        boolean isCommandValid = COMMAND_LIST.stream()
            .anyMatch(command -> command.command.equalsIgnoreCase(userInput));
        if (userInput.length() == 1 || isCommandValid) {
            return null;
        }
        return new ValidatorErrorEntity("Error: entered the wrong command.");
    }
}
