package CreationalDesignPatterns.SingletonPattern;

import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws Exception {
//        singletonV1 s1 = singletonV1.getInstance();
//        singletonV1 s2 = singletonV1.getInstance();
//
//        System.out.println(s1.toString());
//        System.out.println(s2.toString());

//        HashSet<singletonV4> set = new HashSet<>();
//        set.add(s1);
//        set.add(s2);

       // System.out.println(set.size());

//        for(int i = 0; i < 10000; i++){
//            Thread t1 = new Thread(r);
//            t1.start();
//            t1.join();
//        }


        HashSet<singletonV1> set = new HashSet<>();
        Runnable r = () -> {
            singletonV1 s = singletonV1.getInstance();
            set.add(s);
        };
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0; i < 10000; i++){
            executorService.submit(r);
        }
        executorService.shutdown();

        System.out.println(set.size());
        for(singletonV1 s : set){
            System.out.println(s.toString());
        }

//        HashSet<singletonV4> set = new HashSet<>();
//        Runnable r = () -> {
//            singletonV4 s = singletonV4.getInstance();
//            set.add(s);
//        };
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        for(int i = 0; i < 10000; i++){
//            executorService.submit(r);
//        }
//        executorService.shutdown();
//
//        System.out.println(set.size());
//        for(singletonV4 s : set){
//            System.out.println(s.toString());
//        }
    }
}

/*
Design patterns : Design patterns are typical solutions for common problems in software.
There are three kind of DP's :
-> Creational Patterns :- These patterns provide various object creation mechanisms, which increase flexibility and reuse of existing code.
-> Structural Patterns :- These patterns explain how to assemble objects and classes into larger structures while keeping these structures flexible and efficient.
                          OR Deal with how to structure classes.
-> Behavioural Patterns :- These patterns are concerned with algorithms and the assignment of responsibilities between objects.
                           OR It deals with responsibility of object and object interaction.

Creational Patterns :
    1. Singleton : It lets you ensure only one instance of class throughout the application.
    2. Builder :
    3. Factory Method
    4. Abstract Factory
    5. Prototype + (Registry)

Structural Patterns :
    1. Adapter
    2. Decorator
    3. Facade
    4. FlyWeight

Behavioural Patterns :
    1. Strategy
    2. Observer
    3. Command
    4. Memento


Singleton Design Pattern :

What is singleton class?
Singleton Class means we want to have one and only one object of a class throughout the application, We use singleton DP.

When do we use ?
-> When we need only one object of class that will be constant throughout the application.
-> ForExample Database Connection Object, when we do operation on database we need database connection obj to
   connect to database.
-> It takes some steps to create database connection object, loadDriver, create instance of driver, connect to database.
   So instead of repeating same steps, we can use already created object.

Steps to create singleton object :-

-> First we have to restrict the creation of object, so no one can directly create object of singleton class.
-> How can we restrict other classes?  By making constructor as private.
-> If constructor is private, from where we can access private constructor in order to create object?
   Well create object in class itself, we can access private things in class itself.
-> Now how we will give this object to others?
   By the static method so other classes don't need an object to call static method, they can access directly with class name.
-> So others can access static method, they can create multiple objects right?
   Yes, But we will check before giving object whether it's already created object.
   So we will take static variable instance, if its null we will create object else we return.
-> That's good, but we can access instance variable and make it null, so that it might chance to create another object.
   Yes, so we make instance as private so no can access.

SingletonV1 : It fails in multithreading environment.


SingletonV2 :
-> Synchronized method allows only one thread when multiple threads try to access.
-> But it's not an optimised code, think that when 1000 threads come and try to access synchronized method,
   it allows only one thread at a time so if one thread takes one second to go inside method, it checks instance
   is null, if it is null it creates object else returns it and will come out from the method, now next threads
   get inside one by one, so eventually it gets slower to respond all threads.
-> So synchronized method takes much time.

Singleton V3 :
Eager initialization :
Object created when class loaded. But it created in early, it wastes cpu power and memory.


Singleton V4 :
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
-> Now Assume 1000 threads come and check first if block, it allows all threads since initially instance is null, now threads come and wait outside synchronized
   block, first it allows one thread, it goes inside, checks second if block, instance is null initially, so it
   creates object and came outside, now 2nd thread goes inside and checks if block it returns false and came outside.
   similarly all threads follow the same, now again 10000 threads come, this time first if block return false only.

 */