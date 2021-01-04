package com.prakkmak;

public interface IObservable {
    void attach(IObserver observer);
    void detach(IObserver observer);
    void updateAll();
}
