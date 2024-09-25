package backend.academy.tests;

import backend.academy.hangman.View.SelectionGameModeView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class SelectionCategoryMenuViewTest {

    private SelectionGameModeView menuView;

    @BeforeEach
    void setUp() {
        menuView = new SelectionGameModeView();
    }

    @Test
    void testDisplaySetLevel() {
        assertDoesNotThrow(() -> menuView.displaySetLevel());
    }

    @Test
    void testDisplayGoodbye() {
        assertDoesNotThrow(() -> menuView.printHeading());
    }
}
