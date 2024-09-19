package backend.academy.tests;

import backend.academy.hangman.View.StartMenuView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class StartMenuViewTest {

    private StartMenuView startMenuView;

    @BeforeEach
    void setUp() {
        startMenuView = new StartMenuView();
    }

    @Test
    void testDisplayStartMenu() {
        assertDoesNotThrow(() -> startMenuView.displayStartMenu());
    }

    @Test
    void testDisplayGoodbye() {
        assertDoesNotThrow(() -> startMenuView.displayGoodbye());
    }

    @Test
    void testDisplaySelect() {
        assertDoesNotThrow(() -> startMenuView.displaySelect());
    }

    @Test
    void testDisplayError() {
        assertDoesNotThrow(() -> startMenuView.displayError());
    }
}
