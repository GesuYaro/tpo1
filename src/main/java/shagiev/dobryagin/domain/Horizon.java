package shagiev.dobryagin.domain;

public class Horizon {

    private Color color;

    public Horizon(Color color) {
        this.color = color;
    }

    public void burnWithFlame(Color flameColor) {
        color = flameColor;
    }

    public Color getColor() {
        return color;
    }
}
