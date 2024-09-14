package backend.academy.hangman.View;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SelectionCategoryMenuView {
    public void printHeading() {
        System.out.println("Choose your category");
    }

    public void displaySetLevel() {
        System.out.println("Choose your level");
        System.out.println("[1] Easy level");
        System.out.println("[2] Hard level");
    }
}
