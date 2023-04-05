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

    public boolean isAppeared() {
        return isAppeared;
    }

    public void setAppeared(boolean appeared) {
        isAppeared = appeared;
    }
}
