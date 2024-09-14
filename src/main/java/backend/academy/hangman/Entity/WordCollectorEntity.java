package backend.academy.hangman.Entity;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WordCollectorEntity {
    private List<Character> letters = new ArrayList<>();
}
