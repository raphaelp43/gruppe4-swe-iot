package org.c02.swe.iot.examples;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.LedStatus;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;

public class LedDemo {
    public static void main(String[] args) throws IOException, ParticleException {
        IParticleApi api = new ParticleApi(new ButtonConnection());

        api.callMethod("ledsOff", null); // Schaltet die LEDs aus
        // nn = Position 01-12
        // rrr = rot
        // ggg = grün
        // bbb = blau
        // nnrrrgggbbb
        api.callMethod("led", "01255255255");
        api.callMethod("led", "05255000000"); //red
        api.callMethod("led", "06000255000"); //green
        api.callMethod("led", "07000000255"); //blue
        api.callMethod("led", "11000255255");

        Button grp4Button = new Button(api);
        grp4Button.allLedsOff();

        for (int i = 1; i < 13; i++) {
            grp4Button.setLed(i, Color.green);
        }
        grp4Button.allLedsOff();

        grp4Button.setLed(new LedStatus(2, Color.blue));
        grp4Button.allLedsOff();

        List<LedStatus> ld = new ArrayList<>();
        ld.add(new LedStatus(3, Color.red));
        ld.add(new LedStatus(5, Color.blue));
        ld.add(new LedStatus(12, Color.green));
        ld.add(new LedStatus(10, Color.orange));
        grp4Button.setLeds(ld);
        grp4Button.allLedsOff();
    }

}
