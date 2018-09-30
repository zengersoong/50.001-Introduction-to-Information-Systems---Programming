package designpatterns.libtestmessageboard.src.main.java.com.example;

import designpatterns.libtrafficalert.Observer;

public interface Subject {
	 	void register(Observer o);
	    void unregister(Observer o);
	    void changeCondition (String S);
	

}
