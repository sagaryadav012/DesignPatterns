package CreationalDesignPatterns.SingletonPattern;
public class singletonV1 {
    private static singletonV1 instance = null;
    private singletonV1(){

    }
    public static singletonV1 getInstance(){
        if(instance == null){
            instance = new singletonV1();
        }
        return instance;
    }
}
