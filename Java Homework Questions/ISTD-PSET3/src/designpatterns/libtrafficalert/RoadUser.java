package designpatterns.libtrafficalert;



public class RoadUser implements Observer {
	private Traffic traffic = null;
	
	private String name;
	private static int observerIdTrack =0;
	
	public RoadUser(String name ,Traffic traffic) {
		this.traffic = traffic;
		this.traffic.register(this);  // register itself into the list of observers
		this.name=name;
		
	}

	@Override
	public void update(String message) {
		System.out.println(name + " receive alert: "+ message);






}
}