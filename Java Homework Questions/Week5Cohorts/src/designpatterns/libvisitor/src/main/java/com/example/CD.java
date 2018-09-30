package designpatterns.libvisitor.src.main.java.com.example;

public class CD implements Visitable {
    private double weight;

    public void accept(Visitor v) {
        v.visit(this);
    }

    public CD (double weight) {
        this.weight = weight;
    }

    public CD (String name) {
        if (name.equalsIgnoreCase("psy")) this.weight = 8;
    }
    public double getWeight() {
        return weight;
    }

}