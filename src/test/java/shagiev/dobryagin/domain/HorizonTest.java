package shagiev.dobryagin.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HorizonTest {

    Color initColor = Color.BLACK;
    Color newColor = Color.WHITE;
    Horizon horizon = new Horizon(initColor);

    @Test
    void burnWithFlame_changeColor_correctColor() {
        horizon.burnWithFlame(newColor);
        assertEquals(newColor, horizon.getColor());
    }

    @Test
    void burnWithFlame_sameColor_sameColor() {
        horizon.burnWithFlame(initColor);
        assertEquals(initColor, horizon.getColor());
    }

}