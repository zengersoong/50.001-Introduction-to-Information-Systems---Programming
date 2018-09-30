package designpatterns.libgrandtotalvisitor;

public class Fish<subtotal, weight> implements Visitable {
	private Integer weight;
	private double  subtotal;
	@Override
	public void accept(Visitor v) {
		v.visit(this);
		
	}
	public Fish(subtotal p,weight w ){
		this.weight= (Integer )w;
		this.subtotal=(Integer)p;
	}
	public double getWeight(){
        return weight;
    }
	
	public double  getsubtotal() {
		return subtotal;
	}
    





}

