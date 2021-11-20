package org.c02.swe.iot.effect;


import org.c02.swe.iot.IButton;
import org.c02.swe.iot.cloud.api.ParticleException;

import java.awt.*;

public class SpinningWheel extends AbstractEffect {

    protected int count = 0;
    protected int targetCount;
    protected Color firstColor;
    protected Color secondColor;

    public SpinningWheel(IButton button, int targetCount, Color firstColor,Color secondColor) {
        super(button);
        this.targetCount = targetCount;
        this.firstColor = firstColor;
        this.secondColor = secondColor;
    }
    @Override
    public boolean next() throws ParticleException {
        button.allLedsOff();
        if (count >= targetCount) {
            reset();
            return false;
        }
        for (int i = 1; i <= 11; i=i+2) {
            button.setLed(i, firstColor);
            button.setLed(i+1, secondColor);
            button.allLedsOff();
        }
        count++;
        return true;
    }
/*    @Override
    public boolean next() throws ParticleException {
        if (count >= targetCount) {
            reset();
            return false;
        }
        for (int i = 1; i <= 11; i++) {

            if(i%2 == 0){
                button.setLed(i, firstColor);
            }
            else {
                button.setLed(i, secondColor);
            }

            button.allLedsOff();
        }
        count++;
        return true;
    }
*/
    @Override
    public void reset() throws ParticleException {
        button.allLedsOff();
        count = 0;
    }
}
