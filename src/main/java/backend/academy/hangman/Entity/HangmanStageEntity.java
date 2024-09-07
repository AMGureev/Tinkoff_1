package backend.academy.hangman.Entity;

public class HangmanStageEntity {
    private final String[] stages = {
        """
          +---+
              |
              |
              |
              |
             ===
        """,
        """
          +---+
          O   |
              |
              |
              |
             ===
        """,
        """
          +---+
          O   |
          |   |
              |
              |
             ===
        """,
        """
          +---+
          O   |
         /|   |
              |
              |
             ===
        """,
        """
          +---+
          O   |
         /|\\  |
              |
              |
             ===
        """,
        """
          +---+
          O   |
         /|\\  |
         /    |
              |
             ===
        """,
        """
          +---+
          O   |
         /|\\  |
         / \\  |
              |
             ===
        """
    };

    private int currentStage;
    private final int totalStage = 7;

    public HangmanStageEntity() {
        currentStage = 0;
    }

    public void nextStage() {
        if (currentStage < totalStage - 1) {
            currentStage++;
        }
    }

    public void reset() {
        currentStage = 0;
    }

    public String getCurrentStage() {
        return stages[currentStage];
    }

    public boolean isGameOver() {
        return currentStage == totalStage - 1;
    }
}

