package backend.academy.hangman.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class WordCollectorEntity {
    private List<Character> letters = new ArrayList<>();
}
