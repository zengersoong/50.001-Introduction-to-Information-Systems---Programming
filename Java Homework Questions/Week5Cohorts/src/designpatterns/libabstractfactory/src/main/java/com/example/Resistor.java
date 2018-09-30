package designpatterns.libabstractfactory.src.main.java.com.example;

public class Resistor implements Component {
    @Override
    public void place () {
        System.out.println("In Resistor::place() method.");
    }
}
