package StockApp;

import designpatterns.libtestmessageboard.src.main.java.com.example.Observer;
import designpatterns.libtestmessageboard.src.main.java.com.example.Subject;

public class StockGrabber implements StockObserver {
	
	private Subject subject = null;
	private int observerId;
	private static int observerIdTrack =0;
	
	public StockGrabber(Subject subject) {
		this.subject = subject;
		this.subject.register((Observer) this);  // register itself into the list of observers
		
		observerId = observerIdTrack++;
	}

	@Override
	public void updateStockMessage(String message) {
		System.out.println("StockGrabber " + observerId + " got notified: "+ message);
		
	}

	
}
