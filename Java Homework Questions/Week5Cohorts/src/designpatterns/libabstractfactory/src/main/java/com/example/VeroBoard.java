package designpatterns.libabstractfactory.src.main.java.com.example;
public class VeroBoard implements Board {
    @Override
    public void configure() {
        System.out.println("In VeroBoard::configure() method");
    }
}
