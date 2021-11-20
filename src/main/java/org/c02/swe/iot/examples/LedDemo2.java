package org.c02.swe.iot.examples;

import java.io.IOException;

import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;

public class LedDemo2 {
    public static void main(String[] args) throws IOException, ParticleException {
        IParticleApi api = new ParticleApi(new ButtonConnection());
        api.callMethod("ledsOff", null); // Schaltet die LEDs aus
        // nn = Position 01-12
        // rrr = rot
        // ggg = grün
        // bbb = blau
        // nnrrrgggbbb
        api.callMethod("ledMultiple", "0125525525503255255255");
        api.callMethod("ledsOff", null);
    }
}
