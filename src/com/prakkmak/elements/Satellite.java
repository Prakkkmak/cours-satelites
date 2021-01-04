package com.prakkmak.elements;

import com.prakkmak.IObserver;
import com.prakkmak.Main;
import com.prakkmak.Vector2;
import com.prakkmak.movements.HorizontalMovement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Satellite extends ElementMobile implements ActionListener {

    public Satellite(Vector2 pos){
        super(pos);
    }

    @Override
    public void process() {
        super.process();
        if(this.getPosition().getX() > Main.WIDTH)
            this.setPosition(new Vector2(0, this.getPosition().getY()));
        movement.move(this.getPosition());
    }

    public Satellite(){
        super();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    //TODO Repprendre ce qui est donné + ajout events (SWING .. ) YANI
}
