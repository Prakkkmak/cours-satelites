package com.prakkmak.movements;

import com.prakkmak.Vector2;

import java.util.Vector;

public class HorizontalMovement implements IMovementStrategy {
    private int speed = 1;
    private boolean directionLeft;

    public HorizontalMovement(){
        this(false);
    }

    public HorizontalMovement(boolean directionLeft){
        this.directionLeft = directionLeft;
    }

    @Override
    public void move(Vector2 start) {
        Vector2 translation = Vector2.Right.mul(getSpeed());
        if(this.directionLeft) {
            translation = Vector2.Left.mul(getSpeed());
        }
        start.translate(translation);
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }
    @Override
    public int getSpeed() {
        return speed;
    }

}
