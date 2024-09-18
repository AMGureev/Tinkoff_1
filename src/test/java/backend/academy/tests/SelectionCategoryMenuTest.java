package backend.academy.tests;

import backend.academy.hangman.Controller.DictionaryController;
import backend.academy.hangman.Model.SelectionCategoryMenu;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class SelectionCategoryMenuTest {

    private SelectionCategoryMenu selectionCategoryMenu;
    private DictionaryController mockDictionaryController;

    @BeforeEach
    public void setUp() {
        selectionCategoryMenu = new SelectionCategoryMenu();
        mockDictionaryController = Mockito.mock(DictionaryController.class);
    }

    @Test
    public void testViewCategory() {
        when(mockDictionaryController.getTypes()).thenReturn(List.of("Animals", "Countries", "Movies"));
        selectionCategoryMenu.viewCategory();
    }

    @Test
    public void testInputValidInteger() {
        String input = "2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int result = selectionCategoryMenu.input();
        assertEquals(2, result);
    }

    @Test
    public void testInputInvalidThenValidInteger() {
        String input = "abc\n3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int result = selectionCategoryMenu.input();
        assertEquals(3, result);
    }
}
