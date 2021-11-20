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

        Assert.assertTrue(spinningLed.next());
//        Assert.assertTrue(spinningLed.next());
//        Assert.assertTrue(spinningLed.next());
//        Assert.assertTrue(spinningLed.next());

        List<LedStatus> ledStatuses = new ArrayList<>();

        InOrder inOrder = Mockito.inOrder(buttonInstance);
        ledStatuses.add(new LedStatus(1, Color.red));
        ledStatuses.add(new LedStatus(2, Color.blue));
        inOrder.verify(buttonInstance).setLeds(new ArrayList<>(ledStatuses));
//        ledStatuses.add(new LedStatus(3, Color.red));
//        ledStatuses.add(new LedStatus(4, Color.blue));
//        inOrder.verify(buttonInstance).setLeds(new ArrayList<>(ledStatuses));
//        ledStatuses.add(new LedStatus(5, Color.red));
//        ledStatuses.add(new LedStatus(6, Color.blue));
//        inOrder.verify(buttonInstance).setLeds(new ArrayList<>(ledStatuses));
//        ledStatuses.add(new LedStatus(7, Color.red));
//        ledStatuses.add(new LedStatus(8, Color.blue));
//        inOrder.verify(buttonInstance).setLeds(new ArrayList<>(ledStatuses));
//        ledStatuses.add(new LedStatus(9, Color.red));
//        ledStatuses.add(new LedStatus(10, Color.blue));
//        inOrder.verify(buttonInstance).setLeds(new ArrayList<>(ledStatuses));
//
//        inOrder.verify(buttonInstance).allLedsOff();
//
//        inOrder.verifyNoMoreInteractions();
    }
}
