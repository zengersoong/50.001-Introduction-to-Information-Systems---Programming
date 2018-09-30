package designpatterns.libgeomvisitor;



public class PerimeterVisitor implements Visitor {


    
    private double totalPerimeter=0;

    @Override
    public void visit(Circle c) {
    	totalPerimeter+=c.getPerimeter();
        
    }

    @Override
    public void visit(Rectangle d) {

    	totalPerimeter+=d.getPerimeter();
        
    }




	@Override
	public void visit(Square s) {
		totalPerimeter+=s.getPerimeter();
        
		
	}

	public double getTotalPerimeter() {
		return this.totalPerimeter;
		
	}








}

