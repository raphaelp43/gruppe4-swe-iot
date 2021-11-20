package org.c02.swe.iot.clock;

import org.c02.swe.iot.IButton;

import org.c02.swe.iot.LedStatus;
import org.c02.swe.iot.cloud.api.ParticleException;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ClockUtil {

    protected IButton button;
    protected Color hourColor = Color.red;
    protected Color minuteColor = Color.green;
    protected Color secondColor = Color.blue;

    public ClockUtil(IButton button) {
        this.button = button;
    }

    public void show(Date date) throws ParticleException {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);

        int hours = calendar.get(Calendar.HOUR);
        int minutes = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);

        List<LedStatus> ledStatusList = new ArrayList<>();

        int hourPosition = hours == 0 ? 12 : hours;
        int minutePosition = minutes == 0 ? 12 : (int) Math.ceil((double) minutes / 5);
        int secondPosition = seconds == 0 ? 12 : (int) Math.ceil((double) seconds / 5);

        ledStatusList.add(new LedStatus(hourPosition, hourColor));
        ledStatusList.add(new LedStatus(minutePosition, minuteColor));
        ledStatusList.add(new LedStatus(secondPosition, secondColor));

        button.setLeds(ledStatusList);
    }

}
