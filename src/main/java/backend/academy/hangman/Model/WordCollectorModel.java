package backend.academy.hangman.Model;

import backend.academy.hangman.Entity.WordCollectorEntity;
import backend.academy.hangman.Repository.WordCollectorRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WordCollectorModel implements WordCollectorRepository {
    private final WordCollectorEntity wordCollectorEntity;
    @Override
    public boolean addLetter(char letter) {
        if (!wordCollectorEntity.letters().contains(letter)) {
            wordCollectorEntity.letters().add(letter);
            return true;
        }
        return false;
    }
}
