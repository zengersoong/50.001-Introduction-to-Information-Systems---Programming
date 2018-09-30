package designpatterns.libairpollution;


class Subscriber implements Observer{
	private Subject subject = null;
	private String name;
	
	public Subscriber(String name,Subject subject) {
		this.subject = subject;
		this.subject.register(this);  // register itself into the list of observers
		this.name=name;
		
	}



	@Override
	public void update(double airPollutionIndex) {
		System.out.println(name + " received notification: "+ airPollutionIndex);
		
	}

	
}


	   


