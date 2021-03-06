package org.c02.swe.iot.examples;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.IButton;
import org.c02.swe.iot.LedStatus;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class LedButtonAPIDemo2 {
    public static void main(String[] args) throws ParticleException {
        IParticleApi api = new ParticleApi(new ButtonConnection());
        IButton button = new Button(api);

        button.setLed(new LedStatus(3, Color.blue));

        button.allLedsOff();

        List<LedStatus> statuses = new ArrayList<>();
        statuses.add(new LedStatus(1, Color.white));
        statuses.add(new LedStatus(2, Color.blue));
        statuses.add(new LedStatus(3, Color.red));

        button.setLeds(statuses);

        statuses = new ArrayList<>();
        statuses.add(new LedStatus(2, Color.white));
        statuses.add(new LedStatus(3, Color.blue));
        statuses.add(new LedStatus(4, Color.red));

        button.setLeds(statuses);

        button.allLedsOff();
    }
}
