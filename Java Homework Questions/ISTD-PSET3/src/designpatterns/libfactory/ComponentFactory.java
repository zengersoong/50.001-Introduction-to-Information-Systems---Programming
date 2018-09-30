package com.example;

public class ComponentFactory {
    public Component getComponent (String componentType) {
        if (componentType == null) return null;
        if (componentType.equalsIgnoreCase("RESISTOR")) {
            return new Resistor();
        }
        else if (componentType.equalsIgnoreCase("CAPACITOR")) {
            return new Capacitor();
        }
        else if (componentType.equalsIgnoreCase("DIODE")) {
            return new Diode();
        }
        else return null;
    }
}
