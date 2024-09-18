package backend.academy.tests;

import backend.academy.hangman.Model.StartMenu;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StartMenuTest {

    private StartMenu startMenu;

    @BeforeEach
    public void setUp() {
        startMenu = new StartMenu();
    }

    @Test
    public void testInputValidInteger() {
        String input = "2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int result = startMenu.input();
        assertEquals(2, result);
    }
}
