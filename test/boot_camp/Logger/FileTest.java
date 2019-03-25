package boot_camp.Logger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FileTest {
    @Test
    void shouldReturnTheSameLog() {
        File file = new File();
        assertTrue(file.addLog("Done"));
    }

    @Test
    void shouldReturnLogForPrintMethod() {
        File file = new File();
        file.addLog("Error");
        assertEquals("Error", file.print());
    }

}