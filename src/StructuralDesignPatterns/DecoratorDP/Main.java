package StructuralDesignPatterns.DecoratorDP;

public class Main {
    public static void main(String[] args) {
        Ingridient iceCream =  new ChocoChip(
                                        new StrawberrySyrup(
                                                new MangoScoop(
                                                        new ChocoCone()
                                                )
                                        )
                                );

        System.out.println(iceCream.getCost());
        System.out.println(iceCream.description());
    }
}
/*
Decorator DP : Decorator is a structural design pattern that lets you attach new behaviors to objects by placing
               these objects inside special wrapper objects that contain the behaviors.

-> For example a person is working in ice cream store, and he has to prepare ice cream based on user requirements.
-> There could be multiple flavours of each ingredient.
   Cones -> Mango cone, chocolate cone, some other cones and each cone has different price.
   Scoops -> MangoScope, Strawberry scope, Chocolate Scoop etc. each scoop has different price.
   Syrups -> Strawberry syrup, Chocolate syrup, Mango syrup etc. each syrup has different price.
   Chips -> Choco chips, etc. each chip has different price.
-> Now we have to prepare ice cream on user requirement and print bill.
-> We can't create classes for multiple combinations.
   flavours of cone * flavours of scoops * flavours of syrups * flavours of chips
   It leads to class explosion.
 */