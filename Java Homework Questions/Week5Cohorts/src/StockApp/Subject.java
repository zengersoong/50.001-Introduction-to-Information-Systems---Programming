package StockApp;

import designpatterns.libtestmessageboard.src.main.java.com.example.Observer;

public interface Subject {
	void register(Observer o);
	void unregister(Observer o);
	void notifyObservers();
	

}
