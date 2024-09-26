package backend.academy.tests;

import backend.academy.hangman.Entity.DifficultyLevelEnum;
import backend.academy.hangman.Model.Dictionary;
import backend.academy.hangman.Model.SelectionGameMode;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SelectionGameModeTest {

    private SelectionGameMode selectionGameMode;
    private Dictionary dictionary;

    @BeforeEach
    void setUp() {
        dictionary = mock(Dictionary.class);
        selectionGameMode = Mockito.spy(new SelectionGameMode());
        doReturn(dictionary).when(selectionGameMode).dictionary();
    }

    @Test
    void testGetLevel_easyLevel() {
        assertEquals(DifficultyLevelEnum.EASY, selectionGameMode.getLevel(1));
    }

    @Test
    void testGetLevel_hardLevel() {
        assertEquals(DifficultyLevelEnum.HARD, selectionGameMode.getLevel(2));
    }

    @Test
    void testGetCategory_validChoice() {
        assertEquals("fruit", selectionGameMode.getCategory(2));
    }

    @Test
    void testGetCategory_randomChoice() {
        when(dictionary.getTypes()).thenReturn(List.of("Animals", "Fruits", "Countries"));
        assertEquals("random", selectionGameMode.getCategory(99));
    }
}
