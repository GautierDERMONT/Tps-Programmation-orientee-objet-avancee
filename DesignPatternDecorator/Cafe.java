package DesignPatternDecorator;

public class Cafe implements Boisson {
    @Override
    public String description() {
        return "Café";
    }

    @Override
    public double cout() {
        return 1.0; // Coût de base du café
    }
}

