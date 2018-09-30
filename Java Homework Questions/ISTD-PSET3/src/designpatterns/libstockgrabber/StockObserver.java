package designpatterns.libstockgrabber;



public class StockObserver implements Observer {
	private StockGrabber IBM = null;
	
	private String name;

	
	public StockObserver(StockGrabber stock,String name ) {
		this.IBM = stock;
		this.IBM.register(this);  // register itself into the list of observers
		this.name=name;
		
	}

	@Override
	public void update(String message) {
		System.out.println(name + " receive alert: "+ message);






}





}
