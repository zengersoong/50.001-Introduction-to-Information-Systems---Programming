package designpatterns.libgeomvisitor;

public class AreaVisitor implements Visitor {

	 private double totalArea = 0;
	  

	    @Override
	    public void visit(Circle c) {
	    	
	        totalArea += c.getArea();
	    }

	    @Override
	    public void visit(Rectangle d) {

	    	
	        totalArea += d.getArea();
	    }


		@Override
		public void visit(Square s) {
			
	        totalArea += s.getArea();
			
		}
		public double getTotalArea() {
			return this.totalArea;
	}
		

}











