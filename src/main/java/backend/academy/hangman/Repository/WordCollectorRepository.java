package backend.academy.hangman.Repository;

import java.util.List;

public interface WordCollectorRepository {
    void addLetter(char letter);

    List<Character> getLetters();
}
