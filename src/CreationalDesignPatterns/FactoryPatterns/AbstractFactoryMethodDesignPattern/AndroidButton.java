package CreationalDesignPatterns.FactoryPatterns.AbstractFactoryMethodDesignPattern;

public class AndroidButton implements Button{
    @Override
    public void click() {
        System.out.println("Clicking Android Button");
    }
}
