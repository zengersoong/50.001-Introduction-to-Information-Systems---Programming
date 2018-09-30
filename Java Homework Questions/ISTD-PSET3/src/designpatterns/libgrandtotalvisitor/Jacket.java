package designpatterns.libgrandtotalvisitor;

 
public class Jacket<subtotal> implements Visitable {


	private double  subtotal;
	@Override
	public void accept(Visitor v) {
		v.visit(this);
		
	}
	public Jacket(subtotal p){

		this.subtotal=(Integer) p;
	}

	public double  getsubtotal() {
		return subtotal;
	}
    
}










