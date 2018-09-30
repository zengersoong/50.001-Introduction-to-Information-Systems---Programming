package designpatterns.libtaxvisitor;

public class Electronics implements Visitable {
	public double price;
	public Electronics(double price) {
		this.price=price;
	}
	@Override
	public void accept(Visitor v) {
		v.visit(this);
		
	}

}





