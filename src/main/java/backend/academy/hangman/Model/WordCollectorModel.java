package backend.academy.hangman.Model;

import backend.academy.hangman.Entity.WordCollectorEntity;
import backend.academy.hangman.Repository.WordCollectorRepository;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WordCollectorModel implements WordCollectorRepository {
    private final WordCollectorEntity wordCollectorEntity;

    @Override
    public void addLetter(char letter) {
        if (!wordCollectorEntity.letters().contains(letter)) {
            wordCollectorEntity.letters().add(letter);
        }
    }

    @Override
    public List<Character> getLetters() {
        return wordCollectorEntity.letters();
    }

}
