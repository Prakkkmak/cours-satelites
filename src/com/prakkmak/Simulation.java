package com.prakkmak;

import com.prakkmak.elements.Beacon;
import com.prakkmak.elements.Satellite;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    public static int WATER_LEVEL = 0;
    private List<IElement> elements;
    private List<Satellite> satelites;
    private List<Beacon> beacons;
    private int clock;

    public Simulation() {
        this.elements = new ArrayList<>();
        this.clock = 0;
        this.satelites = new ArrayList<>();
        this.beacons = new ArrayList<>();
    }

    public void process(){
        clock++;
        System.out.println("Clock " + clock);
        for (IElement element : this.elements) {
            element.process();
        }
    }
    public Satellite createSatellite(){
        return createSatellite(0,0);
    }
    public Satellite createSatellite(int x, int y){
        Satellite s = new Satellite(new Vector2(x,y));
        elements.add(s);
        satelites.add(s);
        for (Beacon beacon : beacons) {
            beacon.attach(s);
        }
        return s;
    }
    public Beacon createBeacon(){
        return createBeacon(0, 0);
    }
    public Beacon createBeacon(int x, int y){
        Beacon b = new Beacon(new Vector2(x,y));
        elements.add(b);
        beacons.add(b);
        for(Satellite satelite: satelites){
            b.attach(satelite);
        }
        return b;
    }

    public List<IElement> getElements(){
        return elements;
    }

}
