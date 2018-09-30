package designpatterns.libgrandtotalvisitor;

 
    public class Milk<subtotal> implements Visitable {


    	private double  subtotal;
    	@Override
    	public void accept(Visitor v) {
    		v.visit(this);
    		
    	}
    	public Milk(subtotal p){

    		this.subtotal=(Integer)p;
    	}

    	public double  getsubtotal() {
    		return subtotal;
    	}
        
    }






