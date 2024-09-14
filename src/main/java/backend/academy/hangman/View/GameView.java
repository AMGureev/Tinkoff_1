package backend.academy.hangman.View;

import backend.academy.hangman.Entity.WordEntity;

public class GameView {
    public void greetingOutput() {
        System.out.println("Welcome to the Hangman game!");
    }

    public void printHint(WordEntity word) {
        System.out.println("Hint: " + word.hint());
    }

    public void goodbyeOutput() {
        System.out.println("Exiting the game...");
    }

    public void printWordType(String type) {
        System.out.print("Word type: ");
        System.out.println(type);
    }

    public void gameWonOutput(String word) {
        System.out.println("Congratulations! You guessed the word: " + word);
    }

    public void gameLossOutput(String word) {
        System.out.println("Game Over! The word was: " + word);
    }

    public void returnOutput() {
        System.out.println("Returning to the main menu...");
    }

    public void printWarning() {
        System.out.println("You already guessed this letter.");
    }
}
