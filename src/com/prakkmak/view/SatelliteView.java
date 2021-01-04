package com.prakkmak.view;

import com.prakkmak.elements.Satellite;
import graphicLayer.GOval;

import java.awt.*;

public class SatelliteView extends GOval {
    private static final int SATELITE_DIM = 10;

    public Satellite satellite;

    public SatelliteView(Satellite satellite){
        this.satellite = satellite;
        this.dim = new Dimension(SATELITE_DIM, SATELITE_DIM);
    }

    @Override
    public void repaint(){
        this.setPosition(new Point(satellite.getPosition().getX(), satellite.getPosition().getY()));
        super.repaint();
    }
}
