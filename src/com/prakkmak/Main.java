package com.prakkmak;

import com.prakkmak.elements.Beacon;
import com.prakkmak.elements.Satellite;
import com.prakkmak.movements.HorizontalMovement;
import com.prakkmak.movements.VerticalMovement;
import com.prakkmak.view.BeaconView;
import com.prakkmak.view.SatelliteView;
import graphicLayer.GElement;
import graphicLayer.GLine;
import graphicLayer.GRect;
import graphicLayer.GSpace;

import java.awt.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static final String SEED = "YOLO";

    public static final int SIM_SPEED = 10;

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    public static final int WATER_Y = 300;

    public static Simulation simulation;
    public static GSpace view;

    public static void main(String[] args) {
        simulation= new Simulation();
        Simulation.WATER_LEVEL = WATER_Y;
        view = new GSpace("Simulation", new Dimension(WIDTH, HEIGHT));
        water();
        populate(SEED);
        view.open();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                simulation.process();
                for (GElement rawContent : view.getRawContents()) {
                    rawContent.repaint();
                }
            }
        }, 0, SIM_SPEED);
    }

    public static void water(){
        GLine line = new GLine(new Point(0, WATER_Y), new Point(WIDTH, WATER_Y));
        line.setColor(Color.BLACK);
        line.setWidth(3);
        view.addElement(line);
        GRect water = new GRect();
        water.setPosition(new Point(0, WATER_Y));
        water.setDimension(new Dimension(WIDTH, WATER_Y));
        water.setColor(Color.decode("#2980b9"));
        view.addElement(water);
    }

    public static void populate(String seed){
        Random random = new Random(seed.hashCode());
        for(int i = 0; i < 10; i++){
            int x = random.nextInt(WIDTH);
            int y = random.nextInt(HEIGHT - WATER_Y);
            createBeacon(x,WATER_Y + y);
        }
        for(int i = 0; i < 2; i++){
            int x = random.nextInt(WIDTH);
            int y = random.nextInt((HEIGHT - WATER_Y) / 4);
            createSatellite(x,y);
        }

    }

    public static void createBeacon(int x, int y){
        Beacon beacon = simulation.createBeacon(x,y);
        beacon.changeMovement(new VerticalMovement());
        BeaconView beaconView = new BeaconView(beacon);
        view.addElement(beaconView);
    }

    public static void createSatellite(int x, int y){
        Satellite satellite = simulation.createSatellite(x,y);
        satellite.changeMovement(new HorizontalMovement());
        SatelliteView satelliteView = new SatelliteView(satellite);
        view.addElement(satelliteView);
    }
}
