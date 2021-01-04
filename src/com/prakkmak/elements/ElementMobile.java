package com.prakkmak.elements;

import com.prakkmak.IElement;
import com.prakkmak.Vector2;
import com.prakkmak.movements.IMovementStrategy;

import javax.swing.text.Element;

public abstract class ElementMobile implements IElement {
    private Vector2 position;
    protected IMovementStrategy movement;

    public ElementMobile(Vector2 position){
        this.position = position;
    }

    public ElementMobile(){
        position = new Vector2();
    }

    @Override
    public void process() {
        movement.move(position);
    }

    public void changeMovement(IMovementStrategy newMovement){
        movement = newMovement;
    }

    public IMovementStrategy getMovement() {
        return movement;
    }

    @Override
    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }
}
