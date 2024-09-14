package backend.academy.hangman.Model;

import lombok.NoArgsConstructor;

import java.util.Scanner;

@NoArgsConstructor
public class StartMenu {
    public int input() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.println("Error: enter an integer [1-3]");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public void exit() {
        System.exit(0);
    }
}
