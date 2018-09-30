package designpatterns.libabstractfactory.src.main.java.com.example;

public class Capacitor implements Component {
    @Override
    public void place () {
        System.out.println("In Capacitor::place() method.");
    }
}
