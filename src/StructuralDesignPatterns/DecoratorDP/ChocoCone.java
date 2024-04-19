package StructuralDesignPatterns.DecoratorDP;

public class ChocoCone implements Ingridient{
    @Override
    public double getCost() {
        return 25;
    }

    @Override
    public String description() {
        return "Choco Cone";
    }
}
