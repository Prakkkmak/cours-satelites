package com.prakkmak.view;

import com.prakkmak.elements.Beacon;
import graphicLayer.GOval;
import graphicLayer.GRect;

import java.awt.*;

public class BeaconView extends GRect {
    private static final int BEACON_DIM_X = 10;
    private static final int BEACON_DIM_Y = 20;

    public Beacon beacon;

    public BeaconView(Beacon beacon){
        this.beacon = beacon;
        this.dim = new Dimension(BEACON_DIM_X, BEACON_DIM_Y);
    }

    @Override
    public void repaint(){
        this.setPosition(new Point(beacon.getPosition().getX(), beacon.getPosition().getY()));
        super.repaint();
    }
}
