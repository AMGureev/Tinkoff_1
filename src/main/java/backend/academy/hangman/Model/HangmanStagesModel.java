package backend.academy.hangman.Model;

import lombok.Getter;

@Getter
public enum HangmanStagesModel {
    STAGE_1("""
          +---+
              |
              |
              |
              |
             ===
        """),
    STAGE_2("""
          +---+
          O   |
              |
              |
              |
             ===
        """),
    STAGE_3("""
          +---+
          O   |
          |   |
              |
              |
             ===
        """),
    STAGE_4("""
          +---+
          O   |
         /|   |
              |
              |
             ===
        """),
    STAGE_5("""
          +---+
          O   |
         /|\\  |
              |
              |
             ===
        """),
    STAGE_6("""
          +---+
          O   |
         /|\\  |
         /    |
              |
             ===
        """),
    STAGA_7("""
          +---+
          O   |
         /|\\  |
         / \\  |
              |
             ===
        """);

    private final String value;

    HangmanStagesModel(String value) {
        this.value = value;
    }

    public HangmanStagesModel nextStage() {
        HangmanStagesModel[] values = HangmanStagesModel.values();
        int ordinal = this.ordinal();
        return values[(ordinal + 1) % values.length];
    }
}
