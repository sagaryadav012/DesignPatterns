package CreationalDesignPatterns.FactoryPatterns.AbstractFactoryMethodDesignPattern;

public class IOSMenu implements Menu{
    @Override
    public void render() {
        System.out.println("Rendering IOS Menu");
    }
}
