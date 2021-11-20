package org.c02.swe.iot.effect;


import org.c02.swe.iot.IButton;
import org.c02.swe.iot.cloud.api.ParticleException;

import java.awt.*;

public class SpinningWheel extends AbstractEffect {

    protected int count = 1;
    protected Color firstColor = Color.red;
    protected Color secondColor = Color.blue;

    public SpinningWheel(IButton button) {
        super(button);
    }

    @Override
    public boolean next() throws ParticleException {
        if (count >= 11) {
            reset();
            return false;
        }
        button.setLed(count, firstColor);
        button.setLed(count + 1, secondColor);
        count += 3;
        return true;
    }

    @Override
    public void reset() throws ParticleException {
        button.allLedsOff();
        count = 0;
    }
}
