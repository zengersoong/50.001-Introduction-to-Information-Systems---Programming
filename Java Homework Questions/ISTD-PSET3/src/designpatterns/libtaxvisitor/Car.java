package designpatterns.libtaxvisitor;

public class Car implements Visitable {
	public double price;
	public Car(double price) {
		this.price=price;
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
		
	}


}
      // Your code goes here





