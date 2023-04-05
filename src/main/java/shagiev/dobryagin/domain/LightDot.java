package shagiev.dobryagin.domain;

public class LightDot {

    private int size;

    public LightDot(int size) {
        this.size = size;
    }

    public Flash flash() {
        return new Flash();
    }

    public void sprawl() {
        size++;
    }

    public int getSize() {
        return size;
    }
}
