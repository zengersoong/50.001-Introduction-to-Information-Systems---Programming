package designpatterns.libabstractfactory.src.main.java.com.example;

public class BreadBoard implements Board {
    @Override
    public void configure () {
        System.out.println ("In BreadBoard::configure() method.");
    }
}
