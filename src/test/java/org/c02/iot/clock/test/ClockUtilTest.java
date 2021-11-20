package org.c02.iot.clock.test;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.IButton;
import org.c02.swe.iot.LedStatus;
import org.c02.swe.iot.clock.ClockUtil;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClockUtilTest {


    @Test
    public void testShow() throws ParticleException {
        IButton buttonInstance = Mockito.mock(IButton.class);

        ClockUtil clockUtil = new ClockUtil(buttonInstance);

        Date testdate = new Date();
        testdate.setHours(3);
        testdate.setMinutes(30);
        testdate.setSeconds(45);

        clockUtil.show(testdate);

        List<LedStatus> ledStatusList = new ArrayList<>();
        ledStatusList.add(new LedStatus(3, Color.red));
        ledStatusList.add(new LedStatus(6, Color.green));
        ledStatusList.add(new LedStatus(9, Color.blue));

        Mockito.verify(buttonInstance).setLeds(ledStatusList);
    }
}
