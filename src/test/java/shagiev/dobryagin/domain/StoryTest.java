package shagiev.dobryagin.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

class StoryTest {

    final LightDot lightDotMock = mock();
    final Horizon horizonMock = mock();
    final Sun sun1 = mock();
    final Sun sun2 = mock();
    final List<Sun> suns = List.of(sun1, sun2);
    final Flash flashMock = mock();
    final Story story = new Story(lightDotMock, horizonMock, suns);

    @BeforeEach
    public void setUp() {
        when(lightDotMock.flash()).thenReturn(flashMock);
    }

    @Test
    void tellStory() {
        story.tellStory();
        var inOrder = inOrder(lightDotMock, horizonMock, flashMock, sun1, sun2);
        inOrder.verify(lightDotMock).flash();
        inOrder.verify(lightDotMock).sprawl();
        inOrder.verify(sun1).appear();
        inOrder.verify(sun2).appear();
        inOrder.verify(horizonMock).burnWithFlame(any());
        inOrder.verify(flashMock).flow();
    }
}