package org.c02.swe.iot.examples;

import java.awt.Color;

import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.IButton;
import org.c02.swe.iot.Button;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;

public class LedButtonAPIDemo {
    public static void main(String[] args) throws ParticleException {
        IParticleApi api = new ParticleApi(new ButtonConnection());
        IButton button = new Button(api);
        button.setLed(1, Color.orange);
        button.setLed(2, Color.white);
        button.setLed(3, Color.green);
        button.setLed(4, Color.red);
        button.setLed(5, Color.blue);
        button.allLedsOff();
    }
}
