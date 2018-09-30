package designpatterns.libtaxvisitor;

public class Chocolate implements Visitable {
	public double price;
	public Chocolate(double price) {
		this.price=price;
	}
	@Override
	public void accept(Visitor v) {
		v.visit(this);
		
	}






}
