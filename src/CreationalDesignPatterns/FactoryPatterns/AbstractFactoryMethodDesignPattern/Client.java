package CreationalDesignPatterns.FactoryPatterns.AbstractFactoryMethodDesignPattern;

public class Client {
    public static void main(String[] args) {
        UIFactory uiFactory = Flutter.getUIFactory(Platform.IOS);
        Button button = uiFactory.createButton();
        Menu menu = uiFactory.createMenu();

        button.click();
        menu.render();
    }
}

/*
Abstract Factory DP :
-> Abstract Factory is a creational design pattern that lets you produce families of related objects without specifying their concrete classes.

There is a client, client wants to create Button and Menu for different platforms like Android, IOS, etc.
So Client went to Abstract Factory and given his requirements, AbstractFactory created objects and given back to client

Abstract Factory -> UIFactory
Abstract Methods -> CreateButton() and CreateMenu()

Concrete Classes -> AndroidUIFactory and IOSUIFactory
AndroidUIFactory returns AndroidButton and AndroidMenu that were created already
similarly IOSUIFactory returns IOSButton and IOSMenu that were created already

Button -> Implemented By AndroidButton and IOSButton
Menu -> Implemented By AndroidMenu and IOSMenu

In Future if client wants Web Button and Menu he can add easily
step1 -> Button and Menu implemented by WebButton and WebMenu
step2 -> UIFactory implemented by WebUIFactory which returns WebButton and WebMenu.

Pros :
 -> Good for abstraction and family of similar objects.
 -> LooseCoupling between client and Actual concrete code.



 */
