package org.c02.swe.iot.effect;

import org.c02.swe.iot.cloud.api.ParticleException;

public interface IEffect {

    public boolean next() throws ParticleException;
    public void reset() throws ParticleException;


}
