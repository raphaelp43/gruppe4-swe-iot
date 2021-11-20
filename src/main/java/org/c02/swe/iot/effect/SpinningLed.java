package org.c02.swe.iot.effect;


import org.c02.swe.iot.IButton;
import org.c02.swe.iot.cloud.api.ParticleException;

import java.awt.*;

public class SpinningLed extends AbstractEffect {

    protected int count = 0;
    protected int targetCount;
    protected Color color;

    public SpinningLed(IButton button, int targetCount, Color color) {
        super(button);
        if (targetCount >= 0){

            this.targetCount = targetCount;
            this.color = color;
        }
        else {
            throw new IllegalArgumentException("Count must be >= 0");
        }

    }

    @Override
    public boolean next() throws ParticleException {
        if (count >= targetCount) {
            reset();
            return false;
        }
        for (int i = 1; i <= 11; i++) {
            button.setLed(i, color);
            button.allLedsOff();
        }
        count++;
        return true;
    }

    @Override
    public void reset() throws ParticleException {
        count = 0;
    }
}
