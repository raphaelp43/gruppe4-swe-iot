package org.c02.iot.effect.test;

import org.c02.swe.iot.IButton;
import org.c02.swe.iot.cloud.api.ParticleException;
import org.c02.swe.iot.effect.WhiteLedRunning;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.awt.*;

public class WhiteLedRunningTest {


    @Test
    public void testReset() throws ParticleException {
        //setup
        IButton buttonInstance = Mockito.mock(IButton.class);

        WhiteLedRunning poc = new WhiteLedRunning(buttonInstance);
        poc.reset();

        Mockito.verify(buttonInstance).allLedsOff();
        Mockito.verifyNoMoreInteractions(buttonInstance);
    }

    @Test
    public void testOneTick() throws ParticleException{
        //setup
        IButton buttonInstance = Mockito.mock(IButton.class);
        WhiteLedRunning poc = new WhiteLedRunning(buttonInstance);

        Assert.assertTrue(poc.next());

        Mockito.verify(buttonInstance).setLed(1, Color.white);
        Mockito.verifyNoMoreInteractions(buttonInstance);
    }


    @Test
    public void testSequenceTwoTicks() throws ParticleException{
        //setup
        IButton buttonInstance = Mockito.mock(IButton.class);
        WhiteLedRunning poc = new WhiteLedRunning(buttonInstance);

        Assert.assertTrue(poc.next());
        Assert.assertTrue(poc.next());

        InOrder inOrder = Mockito.inOrder(buttonInstance);

        inOrder.verify(buttonInstance).setLed(1, Color.white);
        inOrder.verify(buttonInstance).setLed(2, Color.white);

        inOrder.verifyNoMoreInteractions();
    }

    @Test
    public void testSequence() throws ParticleException {
        //setup
        IButton buttonInstance = Mockito.mock(IButton.class);
        WhiteLedRunning poc = new WhiteLedRunning(buttonInstance);

        while (poc.next()) {
        }

        InOrder inOrder = Mockito.inOrder(buttonInstance);
        for (int count = 1; count <= 10; count++) {
            inOrder.verify(buttonInstance).setLed(count, Color.white);
        }
        inOrder.verify(buttonInstance).allLedsOff();
        inOrder.verifyNoMoreInteractions();
    }

}
