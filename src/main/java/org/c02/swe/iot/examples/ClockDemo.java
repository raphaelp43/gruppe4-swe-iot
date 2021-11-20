package org.c02.swe.iot.examples;

import java.io.IOException;
import java.util.GregorianCalendar;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.IButton;
import org.c02.swe.iot.clock.ClockUtil;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;

public class ClockDemo {
    public static void main(String[] args) throws IOException, ParticleException, InterruptedException {
        IParticleApi api = new ParticleApi(new ButtonConnection());
        IButton demoButton = new Button(api);
        ClockUtil demoClockUtil = new ClockUtil(demoButton);

        while (true) {
            demoClockUtil.show(new GregorianCalendar().getTime());
            Thread.sleep(1000);
        }
    }
}
