package com.prakkmak.elements;

import com.prakkmak.*;
import com.prakkmak.movements.SurfaceMovement;
import com.prakkmak.movements.VerticalMovement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Beacon extends ElementMobile implements IObservable {

    public static final int BEACON_RANGE = 300;

    private List<IObserver> observers;
    private Object data;

    public Beacon(Vector2 position){
        super(position);
        this.observers = new ArrayList<>();
    }
    public Beacon(){
        super();
        this.observers = new ArrayList<>();
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public void process(){
        if(null == data) collectData();
        if(isInSurface()){
            updateAllInRange();
        }
        else{
            super.process();
        }
    }

    @Override
    public void attach(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void updateAll() {
        for (IObserver observer : observers) {
            observer.update(this.getData());
        }
    }

    public void updateAllInRange(){
        for (IObserver observer : getObserversInRange()) {
            observer.update(this.getData());
            setData(null);
            changeMovement(new VerticalMovement());
            this.getPosition().setY(this.getPosition().getY() + 1);
        }
    }

    private void collectData(){
        double d = RandomGenerator.getInstance().nextDouble();
        if(d < 0.005f){
            setData(new Object());
            changeMovement(new SurfaceMovement());
        }
    }

    private Boolean isInSurface(){
        return this.getPosition().getY() < Main.WATER_Y - 10;
    }

    private List<IObserver> getObserversInRange(){
        List<IObserver> observers = new ArrayList<>();
        for (IObserver observer : this.observers) {
            if(getPosition().distance(observer.getPosition()) < BEACON_RANGE)
                observers.add(observer);
        }
        return observers;
    }




}
