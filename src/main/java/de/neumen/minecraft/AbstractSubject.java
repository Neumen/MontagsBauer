package de.neumen.minecraft;

import java.util.ArrayList;

public abstract class AbstractSubject {
    private final ArrayList<IObserver> observers = new ArrayList<>();

    public void registerObserver(IObserver observer) {
        observers.add(observer);
    }

    public void deRegisterObserver(IObserver observer) {
        observers.remove(observer);
    }

    public void onChange(ChatEvent ce) {
        for (IObserver obs:observers) {
            obs.update(ce);
        }
    }
}
