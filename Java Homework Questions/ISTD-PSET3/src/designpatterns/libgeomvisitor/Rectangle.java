package designpatterns.libgeomvisitor;

public class Rectangle<breath, length> implements Visitable {
	private double breath;
	private double length;
	private double perimeter;
	@Override
	public void accept(Visitor v) {
		v.visit(this);
		
	}
	public Rectangle(breath b, length l){
		this.breath= (Integer)b;
		this.length=(Integer)l;
		
	}
	public double getBreath() {
		return this.breath;
	}
	public double getLength() {
		return this.length;
	}
	public double getArea(){
        return (double)this.getBreath()*(double)this.getLength();
    }
	
	public double  getPerimeter() {
		this.perimeter=2*(double)this.getBreath()+2*(double)this.getLength();
		return this.perimeter;
	}
    








}

