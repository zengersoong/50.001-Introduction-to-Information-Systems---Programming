package StockApp;


import java.util.ArrayList;

import designpatterns.libtestmessageboard.src.main.java.com.example.Observer;
import designpatterns.libtestmessageboard.src.main.java.com.example.Subject;

public class OilCompanyA  implements Subject{

	private String message = null;
	private ArrayList<Observer> observers = new ArrayList<Observer>();
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
	
	public void postPrice(String message){
		this.message = message;
		notifyObservers();
		
	}
	
	
	
}
