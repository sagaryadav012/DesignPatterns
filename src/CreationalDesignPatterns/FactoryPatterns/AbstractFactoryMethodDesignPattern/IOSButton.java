package CreationalDesignPatterns.FactoryPatterns.AbstractFactoryMethodDesignPattern;

public class IOSButton implements Button{
    @Override
    public void click() {
        System.out.println("Clicking IOS Button");
    }
}
