package designpatterns.libabstractfactory.src.main.java.com.example;

public abstract class AbstractFactory {
    abstract Component getComponent (String component);
    abstract Board getBoard(String board);
}
