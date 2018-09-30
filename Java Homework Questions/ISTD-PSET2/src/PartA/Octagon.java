package PartA;

// Question 1
// total: 10 points

//===============================================
// todo: Modify Octagon class to implement the Comparable<Octagon> interface
//===============================================


public class Octagon implements Comparable<Octagon>{
    private double side;
    public Octagon(double side){
        this.side = side;
    }
    public double getSide() {
        return side;
    }
	public int compareTo(Octagon o ) {
		if (this.side>o.side)
			return 1;
		if (this.side< o.side)
			return  -1;
		return 0;
		
	}
		
	

}

//public int compareTo(Fruit compareFruit) {
//
//	int compareQuantity = ((Fruit) compareFruit).getQuantity();
//
//	//ascending order
//	return this.quantity - compareQuantity;