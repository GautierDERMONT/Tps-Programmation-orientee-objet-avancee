package DesignPatternDecorator;

public abstract class Decorateur implements Boisson {
    protected Boisson boisson;

    public Decorateur(Boisson boisson) {
        this.boisson = boisson;
    }

    @Override
    public String description() {
        return boisson.description();
    }

    @Override
    public double cout() {
        return boisson.cout();
    }
}