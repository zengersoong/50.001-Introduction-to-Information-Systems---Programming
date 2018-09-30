package designpatterns.libtrafficalert;

import java.util.ArrayList;
/*
 * Use the Observer design pattern to develop a traffic alert system that provides instantaneous 
 * alerts to all the subscribed road users about the conditions on the road. 
 * Copy and suitably modify Observer pattern samples discussed in the cohort activities.
 * Create a Traffic class to implement interface Subject. 
 * Create a RoadUser class to implement Observer.  
 */

public class Traffic implements Subject{

	private String message = null;
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	@Override
	public void changeCondition(String s) {
		for (Observer o: observers)
			o.update(s);
	}
	@Override
	public void register(Observer o) {
		observers.add(o);
	}
	@Override
	public void unregister(Observer o) {
		observers.remove(o);
		
	}
	
	public void postMessage(String message){
		this.message = message;
		changeCondition(message);
		
	}
	
	
	
}
