package backend.academy.tests;

import backend.academy.Main;
import backend.academy.hangman.Controller.StartMenuController;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class MainTest {

    private Injector injectorMock;
    private StartMenuController startMenuControllerMock;

    @BeforeEach
    void setUp() {
        injectorMock = mock(Injector.class);
        startMenuControllerMock = mock(StartMenuController.class);
        when(injectorMock.getInstance(StartMenuController.class)).thenReturn(startMenuControllerMock);
        Main.injector(injectorMock);
    }

    @Test
    void testMainMethod() {
        Main.main(new String[]{});
        verify(startMenuControllerMock).start();
        verify(injectorMock).getInstance(StartMenuController.class);
    }
}
