package designpatterns.libairpollution;

import java.util.ArrayList;



class AirPollutionAlert implements Subject {
	
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	private double message;
	@Override
	public void notifyObservers() {
		for (Observer o: observers)
			o.update(message);
	}
	@Override
	public void register(Observer o) {
		observers.add(o);
	}
	@Override
	public void unregister(Observer o) {
		observers.remove(o);
		
	}
	
	public void setAirPollutionIndex(double message){
		if(message<100) return; // ignore the messages and don't update for index <100
		this.message = message;
		notifyObservers();
	
	}
}