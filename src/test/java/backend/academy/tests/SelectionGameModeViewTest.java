package backend.academy.tests;

import backend.academy.hangman.Model.Dictionary;
import backend.academy.hangman.Model.SelectionGameMode;
import backend.academy.hangman.View.SelectionGameModeView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class SelectionGameModeViewTest {

    private SelectionGameModeView menuView;
    private SelectionGameMode selectionGameMode;

    @BeforeEach
    void setUp() {
        menuView = new SelectionGameModeView();
        selectionGameMode = Mockito.mock(SelectionGameMode.class);
    }

    @Test
    void testDisplaySetLevel() {
        assertDoesNotThrow(() -> menuView.displaySetLevel());
    }

    @Test
    void testPrintHeading() {
        assertDoesNotThrow(() -> menuView.printHeading());
    }

    @Test
    void testPrintChoiceCategory() {
        assertDoesNotThrow(() -> menuView.printChoiceCategory("Animals"));
    }

    @Test
    void testPrintChoiceLevel() {
        assertDoesNotThrow(() -> menuView.printChoiceLevel("Easy"));
    }

    @Test
    void testViewCategory() {
        Mockito.when(selectionGameMode.dictionary())
            .thenReturn(new Dictionary("test_words.txt"));

        assertDoesNotThrow(() -> menuView.viewCategory(selectionGameMode));
    }

    @Test
    void testPrintErrorWordNotFound() {
        assertDoesNotThrow(() -> menuView.printErrorWordNotFound());
    }

    @Test
    void testPrintInputError() {
        assertDoesNotThrow(() -> menuView.printInputError());
    }
}
