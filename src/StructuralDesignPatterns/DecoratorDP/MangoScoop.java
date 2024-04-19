package StructuralDesignPatterns.DecoratorDP;

public class MangoScoop extends IngredientDecorator{

    public MangoScoop(Ingridient baseIngredient){
        super(baseIngredient);
    }
    @Override
    public double getCost() {
        return baseIngredient.getCost() + 30;
    }

    @Override
    public String description() {
        return baseIngredient.description() + ", Mango Scoop";
    }
}
