package designpatterns.libfactory.src.main.java.com.example;

public class Resistor implements Component {
    @Override
    public void draw () {
        System.out.println ("In Resistor::draw() method.");
    }
}

