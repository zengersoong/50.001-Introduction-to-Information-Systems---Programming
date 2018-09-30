package designpatterns.libabstractfactory.src.main.java.com.example;

public class Diode implements Component {
    @Override
    public void place (){
        System.out.println("In Diode::place() method.");
    }
}
