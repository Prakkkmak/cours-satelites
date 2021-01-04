package com.prakkmak.movements;

import com.prakkmak.Vector2;

public class IdleMovement implements IMovementStrategy {

    int speed = 1;

    @Override
    public void move(Vector2 start) { }

    @Override
    public int getSpeed() {
        return speed;
    }
}
