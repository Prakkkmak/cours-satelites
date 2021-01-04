package com.prakkmak.movements;

import com.prakkmak.Main;
import com.prakkmak.Vector2;

import java.util.Random;

public class VerticalMovement implements IMovementStrategy {

    private int speed = 1;
    @Override
    public void move(Vector2 start) {
        Random random = new Random(Main.SEED.hashCode());
        Vector2 translation = Vector2.Up;
        //int translate = Vector2.Right;
        start.translate(translation);
    }

    @Override
    public int getSpeed() {
        return speed;
    }
}
