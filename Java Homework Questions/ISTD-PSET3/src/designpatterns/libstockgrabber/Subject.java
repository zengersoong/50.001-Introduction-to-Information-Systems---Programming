package designpatterns.libstockgrabber;

 
public interface Subject {
    void register(Observer o);
    void unregister(Observer o);
    void stockUpdate(String S);
}
