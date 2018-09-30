package designpatterns.libgrandtotalvisitor;

import designpatterns.libvisitor.src.main.java.com.example.Book;
import designpatterns.libvisitor.src.main.java.com.example.CD;
import designpatterns.libvisitor.src.main.java.com.example.Clothing;

public class ShoppingVisitor implements Visitor {

  
    private double  totalPrice = 0;

    @Override
    public void visit(Fish f) {

        totalPrice += f.getWeight()*f.getsubtotal();
    }

    @Override
    public void visit(Jacket j) {

        totalPrice += j.getsubtotal() * 1.2;
    }

    @Override
    public void visit (Milk m) {
        totalPrice += m.getsubtotal() ;
    }

    public double getTotal () {
        return totalPrice;
    }
}










