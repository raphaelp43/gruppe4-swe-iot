package org.c02.swe.iot;

import java.awt.Color;
import java.util.List;

import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;

public class Button implements IButton {



    public Button(IParticleApi wrapperInstance) {

    }


    public void setLed(int position, Color color) throws ParticleException {


    }

    public void allLedsOff() throws ParticleException {

    }

    public void setLed(LedStatus status) throws ParticleException {


    }

    public void setLeds(List<LedStatus> statuses) throws ParticleException {


    }
}