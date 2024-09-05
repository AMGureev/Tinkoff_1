package backend.academy.hangman.Entity;

import lombok.Getter;

@Getter
public class WordEntity {
    private String word;
    private String type;
    private String hint;
}
