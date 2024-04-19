package StructuralDesignPatterns.DecoratorDP;

public class StrawberrySyrup extends IngredientDecorator{
    public StrawberrySyrup(Ingridient baseIngredient){
        super(baseIngredient);
    }

    @Override
    public double getCost() {
        return baseIngredient.getCost() + 50;
    }

    @Override
    public String description() {
        return baseIngredient.description() + ", Strawberry Syrup";
    }
}
