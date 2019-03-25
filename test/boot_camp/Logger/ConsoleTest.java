package boot_camp.Logger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ConsoleTest {
    @Test
    void shouldReturnTheSameLog() {
        Console console = new Console();
        assertTrue(console.addLog("Done"));
    }

    @Test
    void shouldReturnLogForPrintMethod() {
        Console console = new Console();
        console.addLog("Error");
        assertEquals("Error", console.print());
    }
}