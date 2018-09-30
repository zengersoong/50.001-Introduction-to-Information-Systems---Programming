package designpatterns.libstockgrabber;

import java.util.ArrayList;



public class StockGrabber implements Subject {
	private String message = null;
	private ArrayList<Observer> observers = new ArrayList<Observer>();

	
	public void postMessage(String message){
		this.message = message;
		stockUpdate(message);
		
	}
	@Override
	public void register(designpatterns.libstockgrabber.Observer o) {
		observers.add(o);
		
	}
	@Override
	public void unregister(designpatterns.libstockgrabber.Observer o) {
		observers.remove(o);
		
	}
	@Override
	public void stockUpdate(String S) {
		for (Observer o: observers)
			o.update(S);
		
	}
}
