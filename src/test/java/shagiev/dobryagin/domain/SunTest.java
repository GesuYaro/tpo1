package shagiev.dobryagin.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SunTest {

    Sun sun;

    @BeforeEach
    public void setUp() {
        sun = new Sun(false);
    }

    @Test
    void appear_notAppeared_true() {
        sun.appear();

        assertTrue(sun.isAppeared());
    }

    @Test
    void appear_appearedTwice_exception() {
        sun.appear();

        assertThrows(UnsupportedOperationException.class, sun::appear);
    }

    @Test
    void disappear_appeared() {
        sun.appear();
        sun.disappear();

        assertFalse(sun.isAppeared());
    }

    @Test
    void disappear_disappearedTwice_exception() {
        sun.appear();
        sun.disappear();

        assertThrows(UnsupportedOperationException.class, sun::disappear);
    }
}