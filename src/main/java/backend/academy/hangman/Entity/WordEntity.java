package backend.academy.hangman.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WordEntity {
    private String word;
    private String type;
    private String hint;
    @Override
    public String toString() {
        return "Word: " + word + "; Type: " + type;
    }
}
