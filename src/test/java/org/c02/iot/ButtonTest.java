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
import java.util.List;

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

    @Test
    public void testSetLed() throws ParticleException {
        Button mockButton = Mockito.mock(Button.class);
        LedStatus status = new LedStatus(1, Color.white);

        Mockito.doNothing().when(mockButton).setLed(1, Color.white);
        Mockito.doCallRealMethod().when(mockButton).setLed(status);

        mockButton.setLed(status);

        Mockito.verify(mockButton).setLed(status);
        Mockito.verify(mockButton).setLed(1, Color.white);
    }

    @Test
    public void testSetSetLeds() throws ParticleException {
        Button mockButton = Mockito.mock(Button.class);

        List<LedStatus> statuses = new ArrayList<>();
        statuses.add(new LedStatus(1, Color.white));
        statuses.add(new LedStatus(2, Color.green));
        statuses.add(new LedStatus(3, Color.red));

        Mockito.doNothing().when(mockButton).setLed(statuses.get(0));
        Mockito.doNothing().when(mockButton).setLed(statuses.get(1));
        Mockito.doNothing().when(mockButton).setLed(statuses.get(2));
        Mockito.doCallRealMethod().when(mockButton).setLeds(statuses);
        mockButton.setLeds(statuses);

        Mockito.verify(mockButton).setLed(statuses.get(0));
        Mockito.verify(mockButton).setLed(statuses.get(1));
        Mockito.verify(mockButton).setLed(statuses.get(2));
        Mockito.verify(mockButton).setLeds(statuses);
    }

}
