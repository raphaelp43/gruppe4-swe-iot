package org.c02.swe.iot.examples;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;
import org.c02.swe.iot.effect.IEffect;
import org.c02.swe.iot.effect.WhiteLedRunning;

public class WhiteLedDemo {
    public static void main(String[] args) throws ParticleException {
        IParticleApi api = new ParticleApi(new ButtonConnection());
        Button button = new Button(api);
        IEffect running = new WhiteLedRunning(button);
        while (running.next()){};
    }
}
