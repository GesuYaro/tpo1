package shagiev.dobryagin.domain;

public class Sun {

    private boolean isAppeared;

    public Sun(boolean isAppeared) {
        this.isAppeared = isAppeared;
    }

    public void appear() {
        if (isAppeared) throw new UnsupportedOperationException();
        isAppeared = true;
    }

    public void disappear() {
        if (!isAppeared) throw new UnsupportedOperationException();
        isAppeared = false;
    }

    public boolean isAppeared() {
        return isAppeared;
    }
}
