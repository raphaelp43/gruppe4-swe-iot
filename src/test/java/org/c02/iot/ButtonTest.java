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
    public void testSetLeds() throws ParticleException {
        IParticleApi api = Mockito.mock(IParticleApi.class);
        Button testButton = new Button(api);

        List<LedStatus> statuses = new ArrayList<>();
        statuses.add(new LedStatus(1, Color.white));
        statuses.add(new LedStatus(2, Color.green));
        statuses.add(new LedStatus(3, Color.red));
        StringBuilder parameter = new StringBuilder();
        for (LedStatus status : statuses) {
            int position = status.getPosition();
            Color color = status.getColor();
            parameter.append(String.format("%02d", position))
                    .append(String.format("%03d", color.getRed()))
                    .append(String.format("%03d", color.getGreen()))
                    .append(String.format("%03d", color.getBlue()));
        }
        testButton.setLeds(statuses);
        Mockito.verify(api).callMethod("ledMultiple", parameter.toString());
    }

}
