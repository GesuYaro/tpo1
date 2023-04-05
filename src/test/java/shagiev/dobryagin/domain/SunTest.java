package shagiev.dobryagin.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SunTest {

    Sun sun = new Sun(false);

    @Test
    void appear_notAppeared_true() {
        sun.setAppeared(false);
        sun.appear();
        assertTrue(sun.isAppeared());
    }

    @Test
    void appear_appeared_exception() {
        sun.setAppeared(true);
        assertThrows(UnsupportedOperationException.class, sun::appear);
    }
}