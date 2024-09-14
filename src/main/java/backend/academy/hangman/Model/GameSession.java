package backend.academy.hangman.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GameSession {
    private String word;
    private Integer attempt;
    private String status;
    @Override
    public String toString() {
        return "Word: " + word + "; Attempt: " + attempt + "; Status: " + status;
    }

    public GameSession(String word) {
        this.word = word;
        this.attempt = 0;
        this.status = "in game...";
    }
}
