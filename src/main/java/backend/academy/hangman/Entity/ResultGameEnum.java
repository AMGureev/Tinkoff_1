package backend.academy.hangman.Entity;

import lombok.Getter;

@Getter
public enum ResultGameEnum {
    WIN("win"),
    DEFEAT("defeat"),
    IN_PROGRESS("in progress...");

    private final String valueResult;

    ResultGameEnum(String valueResult) {
        this.valueResult = valueResult;
    }
}
