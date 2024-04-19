package StructuralDesignPatterns.DecoratorDP;

public class MangoCone implements Ingridient{
    @Override
    public double getCost() {
        return 20;
    }

    @Override
    public String description() {
        return "Mango Cone";
    }
}
