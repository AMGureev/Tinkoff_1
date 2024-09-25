package backend.academy.hangman.Entity;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum CommandInGameEnum {
    GET_HINT("get hint"),
    MENU("menu"),
    EXIT("exit");

    public final String command;

    CommandInGameEnum(String command) {
        this.command = command;
    }

    public static String getStringAboutAllCommands() {
        return Stream.of(CommandInGameEnum.values())
            .map(command -> "\"" + command.command + "\"")
            .collect(Collectors.joining(", "));
    }

    public static boolean isCommandValid(String input) {
        return Arrays.stream(CommandInGameEnum.values())
            .anyMatch(command -> command.command.equalsIgnoreCase(input));
    }

    public static CommandInGameEnum getCommandByString(String input) {
        return Arrays.stream(CommandInGameEnum.values())
            .filter(command -> command.command.equalsIgnoreCase(input))
            .findFirst()
            .orElse(null);
    }
}
