package BehaviouralDesignPatterns.ObserverDP;

import java.util.HashSet;
import java.util.Set;

public class Publisher implements ObserverRegistry{
    Set<Observer> observerSet = new HashSet<>();

    public void addObserver(Observer observer){
        observerSet.add(observer);
    }

    public void removeObserver(Observer observer){
        observerSet.remove(observer);
    }

    public void notifyObservers(String stockName, double currentPrice){
        for(Observer observer : observerSet){
            observer.send(stockName, currentPrice);
        }
    }
}
