package backend.academy.tests;

import backend.academy.hangman.View.SelectionCategoryMenuView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class SelectionCategoryMenuViewTest {

    private SelectionCategoryMenuView menuView;

    @BeforeEach
    void setUp() {
        menuView = new SelectionCategoryMenuView();
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
