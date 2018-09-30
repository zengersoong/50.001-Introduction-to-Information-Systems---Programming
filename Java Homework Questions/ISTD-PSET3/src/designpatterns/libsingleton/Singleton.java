package designpatterns.libsingleton;

/**
 * Created by jit_biswas on 11/28/2016.
 */
public class Singleton {

    private static Singleton instance = null;

    private Singleton() {}

    public static Singleton getInstance () {
        if (instance == null) {
            instance = new Singleton ();
        }
        return instance;
    }

    public static void showMessage () {
        System.out.println ("In Singleton:: showmessage()");
    }
}
