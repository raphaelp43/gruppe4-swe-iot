package org.c02.iot;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.IButton;
import org.c02.swe.iot.LedStatus;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;
import org.junit.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ButtonTest {
    @Test
    public void testWrapper() throws ParticleException {

        IParticleApi api = Mockito.mock(IParticleApi.class);

        Button testButton = new Button(api);

        testButton.allLedsOff();

        Mockito.verify(api).callMethod("ledsOff", null);

    }
    @Test
    public void testWrapperLed() throws ParticleException {

        IParticleApi api = Mockito.mock(IParticleApi.class);

        Button testButton = new Button(api);

        testButton.setLed(1, Color.white);

        Mockito.verify(api).callMethod("led", "01255255255");

    }

    @Test(expected = IllegalArgumentException.class)
    public void testWrapperLedInvalid() throws ParticleException {

        IParticleApi api = Mockito.mock(IParticleApi.class);

        Button testButton = new Button(api);

        testButton.setLed(-1, Color.white);

    }

}
