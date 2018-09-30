package designpatterns.libgeomvisitor;


public class Square<length> implements Visitable {
	private double length;
	private double perimeter;
	@Override
	public void accept(Visitor v) {
		v.visit(this);
		
	}
	public Square(length l){
		this.length= (Integer)l;
		
	}

	public double getLength() {
		return this.length;
	}
	public double getArea(){
        return Math.pow((double)this.getLength(), 2);
    }
	
	public double  getPerimeter() {
		this.perimeter=4.0*(double)this.getLength();
		return this.perimeter;
	}
    








}







