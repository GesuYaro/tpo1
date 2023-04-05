package shagiev.dobryagin.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlashTest {

    Flash flash = new Flash();

    @Test
    void flow() {
        assertEquals(getCorrectOutput(), flash.flow());
    }

    private String getCorrectOutput() {
        return "струится сквозь атмосферу";
    }
}