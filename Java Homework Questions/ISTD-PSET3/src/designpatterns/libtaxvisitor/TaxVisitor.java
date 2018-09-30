package designpatterns.libtaxvisitor;

public class TaxVisitor implements Visitor {
	double totalprice=0;
	double taxC=.40;
	double taxE=.80;
	double taxChoco=.10;
	
	public TaxVisitor(String s) {
		if (s.equals("TAXHOLIDAY")) {
		
			 this.taxChoco=.10;
			 this.taxE=.50;
			 this.taxC=.30;
		}

		
	}
	@Override
	public void visit(Car c) {
		totalprice+=c.price* this.taxC;
		
		
	}

	@Override
	public void visit(Electronics e) {
		totalprice+=e.price* this.taxE;
		
	}

	@Override
	public void visit(Chocolate c) {
		totalprice+=c.price* this.taxChoco;
	}

   public double getTotal() {
	   return totalprice;
   }





}


