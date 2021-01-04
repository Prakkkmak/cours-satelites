package com.prakkmak.movements;

import com.prakkmak.Vector2;

import java.util.Vector;

public interface IMovementStrategy {
    void move(Vector2 vector2);
    int getSpeed();
}
