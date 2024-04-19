package StructuralDesignPatterns.DecoratorDP;

public abstract class IngredientDecorator implements Ingridient{
    Ingridient baseIngredient;
    IngredientDecorator(Ingridient baseIngredient){
        this.baseIngredient = baseIngredient;
    }
}
