package org.c02.swe.iot;

import java.awt.*;

public class LedStatus {

    private final Color color;
    private final int position;

    public LedStatus(int positon, Color color) {
        this.position = positon;
        this.color = color;
    }

    public int getPosition() {
        return position;
    }

    public Color getColor() {
        return color;
    }
}
