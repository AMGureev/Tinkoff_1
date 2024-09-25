package backend.academy.hangman.Entity;

import lombok.Getter;

@Getter
public enum DifficultyLevelEnum {
    EASY("EASY"),
    HARD("HARD");

    private final String valueLevel;

    DifficultyLevelEnum(String valueLevel) {
        this.valueLevel = valueLevel;
    }
}
