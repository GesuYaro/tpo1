package shagiev.dobryagin.domain;

import java.util.List;

public class Story {

    private final LightDot lightDot;
    private final Horizon horizon;
    private final List<Sun> suns;

    public Story(LightDot lightDot, Horizon horizon, List<Sun> suns) {
        this.lightDot = lightDot;
        this.horizon = horizon;
        this.suns = suns;
    }

    public void tellStory() {
        Flash flash = lightDot.flash();
        lightDot.sprawl();
        suns.forEach(Sun::appear);
        horizon.burnWithFlame(Color.WHITE);
        flash.flow();
    }
}
