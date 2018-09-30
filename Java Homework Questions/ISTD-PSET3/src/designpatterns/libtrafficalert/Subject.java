package designpatterns.libtrafficalert;

public interface Subject {
    void register(Observer o);
    void unregister(Observer o);
    void changeCondition (String S);
}
