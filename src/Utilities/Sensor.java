package Utilities;

import java.util.ArrayList;
import java.util.List;

public class Sensor implements Subject{
	
	//Class variables
    private boolean occupied;
    private List<Observer> observers;

    //Constructor
    public Sensor() {
        observers = new ArrayList<>();
    }

    //Methods

    
     /* This method sets the occupancy status of the parking space and notifies observers
     * @param occupied true if the parking space is occupied, false otherwise
     */
    public void setOccupancy(boolean occupied) {
        this.occupied = occupied;
        notifyObservers();
    }

    
     /* This method returns if the parking space is occupied
     * @return returns true if the parking space is occupied, false otherwise
     */
    public boolean isOccupied() {
        return occupied;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(occupied);
        }
    }
}
