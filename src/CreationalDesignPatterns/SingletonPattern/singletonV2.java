package CreationalDesignPatterns.SingletonPattern;

/*



 */
public class singletonV2 {
    private static singletonV2 instance = null;
    private singletonV2(){

    }

    public static synchronized singletonV2 getInstance(){
        if(instance == null){
            instance = new singletonV2();
        }
        return instance;
    }

}


// Use synchronized method to ensure only one object create in multi thread environment
// cons : it takes more time