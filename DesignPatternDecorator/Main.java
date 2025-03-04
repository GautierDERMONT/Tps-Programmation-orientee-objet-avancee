package DesignPatternDecorator;

public class Main {
    public static void main(String[] args) {
        Boisson boisson = new Cafe();
        System.out.println(boisson.description() + " : " + boisson.cout() + "€");

        boisson = new Lait(boisson);
        System.out.println(boisson.description() + " : " + boisson.cout() + "€");

        boisson = new Sucre(boisson);
        System.out.println(boisson.description() + " : " + boisson.cout() + "€");

        boisson = new Caramel(boisson);
        System.out.println(boisson.description() + " : " + boisson.cout() + "€");
    }
}