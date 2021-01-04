package com.prakkmak.movements;

import com.prakkmak.Vector2;

public class SurfaceMovement implements IMovementStrategy {
    private int speed = 1;
    @Override
    public void move(Vector2 start) {
        Vector2 translation = Vector2.Down;
        start.translate(translation);
    }

    @Override
    public int getSpeed() {
        return speed;
    }
}
