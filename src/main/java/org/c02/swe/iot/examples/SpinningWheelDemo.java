package org.c02.swe.iot.examples;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;
import org.c02.swe.iot.effect.IEffect;
import org.c02.swe.iot.effect.SpinningWheel;
import org.c02.swe.iot.effect.WhiteLedRunning;

import java.awt.*;

public class SpinningWheelDemo {
    static IParticleApi api = new ParticleApi(new ButtonConnection());

    public static void main(String[] args) throws ParticleException {

        Button button = new Button(api);

        IEffect running = new SpinningWheel(button,1, Color.red,Color.blue);
        button.allLedsOff();
        while (running.next()){};
        button.allLedsOff();
    }
}
