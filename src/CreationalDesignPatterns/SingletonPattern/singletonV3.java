package CreationalDesignPatterns.SingletonPattern;

/*
    Eager initialization :
    Object created when class loaded. But it created in early, it wastes cpu power and memory.
 */
public class singletonV3 {
    private static singletonV3 instance = new singletonV3();
    private singletonV3(){
    }
    public static singletonV3 getInstance(){
        return instance;
    }
}
