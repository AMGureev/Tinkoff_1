package backend.academy.hangman.View;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class StartMenuView {
    public void displayStartMenu() {
        System.out.println("Welcome to Hangman!");
    }

    public void displayGoodbye() {
        System.out.println("Goodbye!");
    }

    public void displaySelect() {
        System.out.println("[1] Start Game");
        System.out.println("[2] View Statistics");
        System.out.println("[3] Exit");
        System.out.print("Please select an option: ");
    }

    public void displayError() {
        System.out.println("Error: please, input integer[1-3]");
    }
}
