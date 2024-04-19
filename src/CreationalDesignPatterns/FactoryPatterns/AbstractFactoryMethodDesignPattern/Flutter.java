package CreationalDesignPatterns.FactoryPatterns.AbstractFactoryMethodDesignPattern;

public class Flutter {
    public static UIFactory getUIFactory(Platform platform){
        if(platform.equals(Platform.ANDROID)){
            return new AndroidUIFactory();
        }
        else if(platform.equals(Platform.IOS)){
            return new IOSUIFactory();
        }
        else{
            throw new UnsupportedOperationException("This platform is not yet available");
        }
    }
}
