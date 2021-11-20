package org.c02.iot.effect.test;

import org.c02.swe.iot.IButton;
import org.c02.swe.iot.LedStatus;
import org.c02.swe.iot.cloud.api.ParticleException;
import org.c02.swe.iot.effect.SpinningLed;
import org.c02.swe.iot.effect.SpinningWheel;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpinningWheelTest {

    @Test
    public void testSpinningWheel() throws ParticleException {
        IButton buttonInstance = Mockito.mock(IButton.class);

        SpinningWheel spinningLed = new SpinningWheel(buttonInstance);
        InOrder inOrder = Mockito.inOrder(buttonInstance);
        for (int i = 1; i <= 10; i+=3){
            Assert.assertTrue(spinningLed.next());
            inOrder.verify(buttonInstance).allLedsOff();
            List<LedStatus> ledStatuses = new ArrayList<>();
            ledStatuses.add(new LedStatus(i, Color.red));
            ledStatuses.add(new LedStatus(i+1, Color.blue));
            inOrder.verify(buttonInstance).setLeds(ledStatuses);
        }
        inOrder.verifyNoMoreInteractions();
    }
}
