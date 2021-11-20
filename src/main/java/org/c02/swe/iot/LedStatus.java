package org.c02.swe.iot;

import java.awt.*;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LedStatus ledStatus = (LedStatus) o;
        return position == ledStatus.position && Objects.equals(color, ledStatus.color);
    }
}
