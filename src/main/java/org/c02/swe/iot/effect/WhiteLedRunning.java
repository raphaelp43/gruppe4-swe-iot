package org.c02.swe.iot.effect;


import org.c02.swe.iot.IButton;
import org.c02.swe.iot.cloud.api.ParticleException;

import java.awt.*;

public class WhiteLedRunning extends AbstractEffect {

    protected int count = 1;

    public WhiteLedRunning(IButton button) {
        super(button);
    }

    @Override
    public boolean next() throws ParticleException {
        if (count >= 11) {
            reset();
            return false;
        }
        button.setLed(count,Color.white);
        count++;
        return true;
    }

    @Override
    public void reset() throws ParticleException{
        button.allLedsOff();
        count = 0;
    }
}
