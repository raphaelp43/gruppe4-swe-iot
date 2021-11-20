package org.c02.swe.iot.effect;


import org.c02.swe.iot.IButton;
import org.c02.swe.iot.LedStatus;
import org.c02.swe.iot.cloud.api.ParticleException;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SpinningWheel extends AbstractEffect {

    protected int count = 1;
    protected Color firstColor = Color.red;
    protected Color secondColor = Color.blue;
    protected List<LedStatus> ledStatuses = new ArrayList<>();

    public SpinningWheel(IButton button) {
        super(button);
    }

    @Override
    public boolean next() throws ParticleException {
        if (count >= 11) {
            reset();
            return false;
        }
        button.allLedsOff();
        ledStatuses = new ArrayList<>();
        ledStatuses.add(new LedStatus(count, firstColor));
        ledStatuses.add(new LedStatus(count + 1, secondColor));
        button.setLeds(ledStatuses);
        count += 3;
        return true;
    }

    @Override
    public void reset() throws ParticleException {
        button.allLedsOff();
        count = 1;
    }
}
