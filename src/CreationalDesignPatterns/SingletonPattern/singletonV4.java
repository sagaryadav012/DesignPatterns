package CreationalDesignPatterns.SingletonPattern;

/*
Use locks :
Single Check Lock :
           if(instance == null){
                synchronized (singletonV4.class){
                    instance = new singletonV4();
                }
            }
-> In single check lock, Assume 1000 threads come and checks if instance is null, initially it's null so all threads
   entered and waiting outside synchronized block since synchronized block allows only one thread, remaining threads
   will be allowed one by one, and it leads to create multiple objects of same class.
-> So single check lock will not work in multithreading environment.

DCL(Double checking Lock Approach) :
-> In this approach we use double check lock, means we will check twice to make the process speed as well as
   it supports in multithreading environment.

   if(instance == null){
            synchronized (singletonV4.class){
                if(instance == null){
                    instance = new singletonV4();
                }
            }
    }
-> Now Assume 1000 threads come and check first if block, it allows all threads, now threads wait outside synchronized
   block, first it allows one thread, it goes inside, checks second if block, instance is null at first time, so it
   creates object and came outside, now 2nd thread goes inside and checks if block it returns false and came outside.
   similarly all threads follow the same, now again 10000 threads come, this time first if block return false only.
 */


public class singletonV4 {
    private static singletonV4 instance = null;
    private singletonV4(){

    }

    /*
    single check lock
     public static singletonV4 getInstance(){
        if(instance == null){
            synchronized (singletonV4.class){
                instance = new singletonV4();
            }
        }
        return instance;
     }
     */

    // double check lock
    public static singletonV4 getInstance(){
        if(instance == null){
            synchronized (singletonV4.class){
                if(instance == null){
                    instance = new singletonV4();
                }
            }
        }
        return instance;
    }
}
