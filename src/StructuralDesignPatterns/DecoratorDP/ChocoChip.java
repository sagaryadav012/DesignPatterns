package StructuralDesignPatterns.DecoratorDP;

public class ChocoChip extends IngredientDecorator{
    public ChocoChip(Ingridient baseIngredient){
        super(baseIngredient);
    }

    @Override
    public double getCost() {
        return baseIngredient.getCost() + 35;
    }

    @Override
    public String description() {
        return  baseIngredient.description() + ", Choco chip";
    }
}
