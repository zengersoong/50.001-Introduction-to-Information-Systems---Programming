package designpatterns.libgeomvisitor;
import java.lang.Math;




public class Circle<radius> implements Visitable {
	private double radius;
	private double perimeter;
	private double area;
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
		
	}
	public Circle(radius r){
		this.radius= (Integer)r;
		
	}
	
	public double getRadius(){
        return this.radius;
    }
	
	public double getArea() {
		this.area=Math.PI*(Math.pow(this.getRadius(), 2));
		return area;
	}
	public double  getPerimeter() {
		this.perimeter=Math.PI*((double)this.getRadius()*2);
		
		return this.perimeter;
	}
    





}









