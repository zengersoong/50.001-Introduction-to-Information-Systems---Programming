package com.example;

/**
 * Created by jit_biswas on 10/11/2017.
 */
public class Context {
    private State state;

    public Context() {
        state = null;
    }

    public void setState(State state) {
        this.state=state;
    }

    public State getState() {
        return state;
    }
}
