package org.c02.swe.iot.cloud.examples;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.IButton;
import org.c02.swe.iot.clock.ClockUtil;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;

public class ClockDemo {

    public static void main(String[] args) throws IOException, ParticleException {
        IParticleApi api = new ParticleApi(new ButtonConnection());
        IButton demoButton = new Button(api);
        ClockUtil demoClockUtil = new ClockUtil(demoButton);

        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.HOUR, 3);
        calendar.set(Calendar.MINUTE, 19);
        calendar.set(Calendar.SECOND, 50);
        Date date = calendar.getTime();

        demoClockUtil.show(date);
    }

}
