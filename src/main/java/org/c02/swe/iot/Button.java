package org.c02.swe.iot;

import java.awt.Color;
import java.util.List;

import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;

public class Button implements IButton {

    private final IParticleApi api;

    public Button(IParticleApi api) {
        this.api = api;
    }

    public void setLed(int position, Color color) throws ParticleException {
        if (position >= 1 && position <= 12) {
            String parameter = String.format("%02d", position) + color.getRed() + color.getGreen() + color.getBlue();
            api.callMethod("led", parameter);
        } else {
            throw new IllegalArgumentException("Position must be between 1 and 12");
        }
    }

    public void allLedsOff() throws ParticleException {
        api.callMethod("ledsOff", null);
    }

    public void setLed(LedStatus status) throws ParticleException {
        this.setLed(status.getPosition(), status.getColor());
    }

    public void setLeds(List<LedStatus> statuses) throws ParticleException {
        for (LedStatus status : statuses) {
            this.setLed(status);
        }
    }
}