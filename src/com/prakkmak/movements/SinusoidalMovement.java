package com.prakkmak.movements;

import com.prakkmak.Vector2;

public class SinusoidalMovement implements IMovementStrategy {

    private  int speed = 1;
    @Override
    public void move(Vector2 start) {
        Vector2 translation = Vector2.Up;
        //int translate = Vector2.Right;
        start.translate(translation);
    }

    @Override
    public int getSpeed() {
        return speed;
    }
}
