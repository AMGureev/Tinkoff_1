package backend.academy.hangman.Model;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StatisticsModel {
    private Integer countGame = 0;
    private List<GameSession> gameSessions = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder answer = new StringBuilder("Count game: " + countGame + "\n");
        int counter = 1;
        for (GameSession game : gameSessions) {
            answer.append(counter++).append(". ").append(game.toString()).append("\n");
        }
        return answer.substring(0, answer.length() - 1);
    }

    public void addGame(GameSession gameSession) {
        this.countGame += 1;
        gameSessions.add(gameSession);
    }
}
