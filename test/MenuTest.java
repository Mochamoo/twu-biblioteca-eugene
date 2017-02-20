import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MenuTest {
    Menu menu;

    @Before
    public void setUp() {
        menu = new Menu();
    }

    @Test
    public void welcomeShouldPrintWelcomeMessage() {
        assertEquals("===Welcome to Biblioteca!===", menu.welcome());
    }

}