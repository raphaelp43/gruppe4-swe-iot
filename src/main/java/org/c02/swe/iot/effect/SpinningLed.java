package org.c02.swe.iot.effect;


import org.c02.swe.iot.IButton;
import org.c02.swe.iot.cloud.api.ParticleException;

import java.awt.*;

public class SpinningLed extends AbstractEffect {

    protected int count;
    protected Color color;

    public SpinningLed(IButton button, int count, Color color) {
        super(button);
        this.count = count;
        this.color = color;
    }

    @Override
    public boolean next() throws ParticleException {
        for (int i = 1; i <= count; i++) {
            for (int j = 1; j <= 12; j++) {
                button.setLed(j, color);
                this.reset();
            }
        }
        return true;
    }

    @Override
    public void reset() throws ParticleException {
        button.allLedsOff();
    }
}
