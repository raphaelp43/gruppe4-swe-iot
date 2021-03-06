package org.c02.iot.effect.test;

import org.c02.swe.iot.IButton;
import org.c02.swe.iot.cloud.api.ParticleException;
import org.c02.swe.iot.effect.SpinningLed;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.awt.*;

public class SpinningLedTest {

    @Test
    public void testSpinningLed() throws ParticleException {
        IButton buttonInstance = Mockito.mock(IButton.class);

        SpinningLed spinningLed = new SpinningLed(buttonInstance, 4, Color.blue);
        Assert.assertTrue(spinningLed.next());
        Assert.assertTrue(spinningLed.next());
        Assert.assertTrue(spinningLed.next());
        Assert.assertTrue(spinningLed.next());
        InOrder inOrder = Mockito.inOrder(buttonInstance);
        for (int j = 1; j <= 4; j++) {
            for (int i = 1; i <= 11; i++) {
                inOrder.verify(buttonInstance).setLed(i, Color.blue);
                inOrder.verify(buttonInstance).allLedsOff();
            }
        }
        inOrder.verifyNoMoreInteractions();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSpinningLedInvalid() throws ParticleException {
        IButton buttonInstance = Mockito.mock(IButton.class);
        new SpinningLed(buttonInstance, -1, Color.green);
    }
}
