package shagiev.dobryagin.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StoryTest {

    LightDot lightDotMock = Mockito.mock(LightDot.class);
    Horizon horizonMock = Mockito.mock(Horizon.class);
    List<Sun> suns = List.of(Mockito.mock(Sun.class), Mockito.mock(Sun.class));
    Flash flashMock = Mockito.mock(Flash.class);
    Story story = new Story(lightDotMock, horizonMock, suns);

    {
        Mockito.when(lightDotMock.flash()).thenReturn(flashMock);
    }

    @Test
    void tellStory() {
        story.tellStory();
        Mockito.verify(lightDotMock).flash();
        Mockito.verify(lightDotMock).sprawl();
        Mockito.verify(horizonMock).burnWithFlame(Mockito.any());
        suns.forEach(s -> Mockito.verify(s).appear());
        Mockito.verify(flashMock).flow();
    }
}