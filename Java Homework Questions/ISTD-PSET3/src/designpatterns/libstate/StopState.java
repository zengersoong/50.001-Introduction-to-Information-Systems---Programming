package com.example;
import java.io.*;
/**
 * From Tutorialspoint
 */

public class StopState implements State {
    public void doAction(Context context) {
        System.out.println("Player is in Stop state.");
        context.setState(this);
    }

    public String toString() {
        return("Stop State");
    }
}