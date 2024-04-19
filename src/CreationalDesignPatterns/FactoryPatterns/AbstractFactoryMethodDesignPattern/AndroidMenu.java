package CreationalDesignPatterns.FactoryPatterns.AbstractFactoryMethodDesignPattern;

public class AndroidMenu implements Menu{
    @Override
    public void render() {
        System.out.println("Rendering Android Menu");
    }
}
