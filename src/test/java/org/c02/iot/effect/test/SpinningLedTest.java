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
        //setup
        IButton buttonInstance = Mockito.mock(IButton.class);

        SpinningLed spinningLed = new SpinningLed(buttonInstance, 4, Color.green);
        Assert.assertTrue(spinningLed.next());


        InOrder inOrder = Mockito.inOrder(buttonInstance);
        for (int j = 1; j <= 4; j++) {
            for (int i = 1; i <= 11; i++) {
                inOrder.verify(buttonInstance).setLed(i, Color.green);
                inOrder.verify(buttonInstance).allLedsOff();
            }
        }
        inOrder.verifyNoMoreInteractions();
    }



}
