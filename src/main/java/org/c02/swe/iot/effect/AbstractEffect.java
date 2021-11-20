package org.c02.swe.iot.effect;

import org.c02.swe.iot.IButton;

public abstract class AbstractEffect implements IEffect {

    protected final IButton button;

    public AbstractEffect(IButton button)
    {
        this.button = button;
    }
}
