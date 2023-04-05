package shagiev.dobryagin.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LightDotTest {

    int initSize = 1;

    LightDot lightDot = new LightDot(initSize);

    @Test
    void flash_notNull() {
        assertNotNull(lightDot.flash());
    }

    @Test
    void sprawl_sizeExpands() {
        lightDot.sprawl();
        assertTrue(lightDot.getSize() > initSize);
    }
}