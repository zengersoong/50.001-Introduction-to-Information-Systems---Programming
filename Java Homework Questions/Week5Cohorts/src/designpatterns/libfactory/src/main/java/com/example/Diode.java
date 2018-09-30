package designpatterns.libfactory.src.main.java.com.example;

public class Diode implements Component {
    @Override
    public void draw (){
        System.out.println ("In Diode::draw() method.");
    }
}
