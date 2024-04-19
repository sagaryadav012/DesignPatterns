# DesignPatterns

DESIGN PATTERNS :- Design patterns are typical solutions for common problems in software.
There are three kind of DP's :
-> Creational Patterns :- These patterns provide various object creation mechanisms, which increase flexibility and reuse of existing code.
-> Structural Patterns :- These patterns explain how to assemble objects and classes into larger structures while keeping these structures flexible and efficient.
                          OR Deal with how to structure classes.
-> Behavioural Patterns :- These patterns are concerned with algorithms and the assignment of responsibilities between objects.
                           OR It deals with responsibility of object and object interaction.

CREATIONAL PATTERNS :-
    1. Singleton : It lets you ensure only one instance of class throughout the application.
    2. Builder :
    3. Factory Method
    4. Abstract Factory
    5. Prototype + (Registry)

STRUCTURAL PATTERNS :-
    1. Adapter
    2. Decorator
    3. Facade
    4. FlyWeight

BEHAVIOURAL PATTERNS :-
    1. Strategy
    2. Observer
    3. Command
    4. Memento


CREATIONAL DESIGN PATTERNS :-
1. SINGLETON DP :

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

2. BUILDER DP :-
What is Builder dp?
-> Builder dp allows us to create complex objects step by step.

When to use?
-> When an object has lots of attributes. some of them are optional and some of them are compulsory.
-> What if we want to validate the object before creation.

Example : Class Student has lots of attributes like name, email, phoneNumber, age, marks, address. Create object of
Student only when age > 18 and some attributes are optional.

How we initialise attributes? Through setters and constructor.

Approach 1(Use Setters) :
-> We can't use setters. since to access setters we need object of class. we can't create object before validation.
   So we can't use setters. Create object of it when only age > 18. In this case it is not possible to use setters.

Approach 2(Use Constructor) :
-> We can initialise attribute through constructor.
   public Student(String name, String phoneNumber, String email, int age, int marks){ }
   But here we can pass name in place of email and pass email in place of name. Compiler won't give error since both
   are same dataType due to this, it leads to bugs.
-> And some attributes are optional right, we need to write multiple combinations of constructors it leads constructor explosion.
   So constructors also not work.

Approach 3 :
-> Take help of helper or builder to build student object.
-> No one should create object of student before validation so make student constructor as private.
-> Since constructor is private, it can be accessible with in class. So create new class with in the class(builder class) with same attributes.
-> Initialise setters to set values. And write method to build student object.
-> Whenever we initialise Student, call builder with help of Student and initialise attributes through setters.


public class Student1 {
    String name;
    String email;
    int age;
    String phoneNumber;

    private Student1(Builder b){
        this.name = b.getName();
        this.email = b.getEmail();
        this.age = b.getAge();
        this.phoneNumber = b.getPhoneNumber();
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    static class Builder{
        String name;
        String email;
        int age;
        String phoneNumber;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return  this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public int getAge() {
            return age;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public Student1 build() throws Exception{
            if(this.age < 18){
                throw new Exception("Age cannot be less than 18");
            }
            if(this.name == null || this.email == null){
                throw  new Exception("Email or name is missing");
            }
            return new Student1(this);
        }
}

3. FACTORY METHOD DP :-
 -> Factory Method DP defines an interface for creating objects, but it let subclasses decides which class to instantiate.
 -> Since this pattern talk about instantiation object, it comes under Object creational Design Pattern.
 -> It delegates object creation to subclasses.

 When we use factory method DP :
 -> Adding new feature to current codebase becomes headache or when we have to create the object depends on some condition or input.

 For example client wants to send notifications to user. Notification could be different types, it could be SMS, EMAIL or PUSH notification.
 Depends on the notification type we need to create object of notification.

 We can write code like this.
 class SendNotification{
    public void send(NotificationType type){
        if(type.equals(NotificationType.SMS)){
            // write code to send SMS notification
        }
        else if(type.equals(NotificationType.PUSH)){
            // write code to send PUSH notification
        }
        else if(type.equals(NotificationType.EMAIL)){
            // write code to send EMAIL notification
        }
    }
  }
-> But the above code violates SRP and OCP principles.
-> Send method has to send notification, But it is doing more than that, It is checking notification type and sending notification.
   But if we have to change this class, It should have only one reason to change.(SRP violates here)
-> OCP : If we add new notification type, we have to modify existing code.


Here factory method comes into picture, It defines common interface and subclasses will implement it.

Notification interface :
public interface Notification {
    public void notifyUser();
}

public class SMSNotification implements Notification{
    @Override
    public void notifyUser() {
        System.out.println("Sending SMS notification...");
    }
}

public class PushNotification implements Notification{
    @Override
    public void notifyUser() {
        System.out.println("Pushing important notification...");
    }
}

public class EmailNotification implements Notification{
    @Override
    public void notifyUser() {
        System.out.println("Sending Email notification...");
    }
}


public class NotificationFactory {
    public Notification createNotification(NotificationType notificationType){
        switch (notificationType){
            case SMS : return new SMSNotification();
            case EMAIL : return new EmailNotification();
            case IMPORTANT : return new PushNotification();
            default: throw new UnsupportedOperationException("This notification not valid");
        }
    }
}

Here notification factory gives notification object based input(Notification Type)

Client Code :
public class Client {
    public static void main(String[] args) {
        NotificationFactory notificationFactory = new NotificationFactory();
        Notification notification = notificationFactory.createNotification(NotificationType.IMPORTANT);

        notification.notifyUser();
    }
}

Why it matters :
Flexibility: Easily add new feature without modifying existing code.
Decoupling: Break free from tight dependencies, enhancing maintainability.
Simplicity: Keep client code oblivious to product creation details, promoting clean architecture.

4. ABSTRACT FACTORY METHOD DP :-
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



5. PROTOTYPE DP :-
-> Prototype DP is copying an existing object rather than creating object from scratch that may include costly operations.

When to use?
-> When object creation includes costly operations, or it takes much time and space to creat object. In that case
   copy an existing object rather than creating from scratch.

How can copy?
There are two ways to copy the object :
1. Shallow copy
2. Deep copy
3. Constructor copy

Approach 1(Shallow Copy) :
-> Shallow copy means we are just copying memory address of original object, If we do any modification, it reflects on original object.
   So shallow copy will not work.

Approach 2(Deep Copy) :
-> Deep copy means, Creat new object and copy all fields of original object manually.
Pros : It will work in most of the cases.
Cons :
-> Every time we need to copy, we will need to duplicate the code.
-> New attributes handling is difficult means if we add new attributes in Student later, we need copy new attributes,
   so we have to change code in every class where we performed copying operation.
-> Private attributes cannot be copied.

Approach 3(Constructor Copy) :
-> In this approach, we copy the object through constructor.
-> Pass original object in constructor to copy all fields in object.
    Student {
        String name;
        int age;
        private String branch;

        public Student(String name, int age, String branch){
            this.name = name;
            this.age = age;
            this.branch = branch;
        }
        public Student(Student original){
            this.name = original.name;
            this.age =  original.age;
            this.branch = original.branch;
        }
    }

    Client code :
      Student original = new Student("sagar", 25, "CSE");
      Student copy = new Student(original) // this time it will call constructor that accepts object
      // It take original object and will copy all fields to new object.

Pros :
-> No code duplication.
-> Easy to manage new attributes.
-> Private attributes can be copied.

Cons : SRP & OCP violation.

How it violates SRP and OCP?
-> Student class has subclass like Intelligent Student.
-> Student original = getStudent(); // It can return either student or intelligent student object.
-> In order to copy, first we need to check is it student or intelligent student then we can call appropriate copy constructor.
-> This thing violates SRP, SRP means class should have only one responsibility, It has more than need to check object and then do copy.
-> OCP violates, If we add one more child to student we need to change existing code to check object and call copy constructor.


Approach 4(copy using clone) :
-> In this approach, we override clone method of object where we pass copy constructor method
-> In main function, we call clone method of object(object can vary)



STRUCTURAL DESIGN PATTERNS :
1. ADAPTER DP :- It helps us to connect two incompatible objects.

-> Here client wants to send mails to user, And he doesn't want to build own SMTP server instead he decides
   to use third party servers.
-> He decides to use SendGrid for mail service, written code will be looks like below

  class Client{
        SendGrid sendGrid = new SendGrid();

        public void sendEmail(String from, String to, String content){
            sendGrid.send(from, to, content);
        }
  }

-> In future, client wants to switch from SendGrid to MailGun. now he needs to re-write entire code again.
   Updated code looks like below.
   class Client{
        MailGun mailGun = new MainGun();

        public void sendEmail(String from, String to, String content){
            mailGun.sendEmail(to, from, content);
        }
  }
-> Now cons of above code are, Re-write code, It violates Dependency inversion principle.
-> DIP means no two concrete classes should not directly depend on each other, it leads to tight coupling.
-> So take interface, it has one method sendEmail. SendGridEmailAdapter and MailGunEmailAdapter will implement
   EmailAdapter interface and provide common method sendEmail, it acts as adapter for sendGrid's method and
   mailGun's method since they do have different method signature.
   
2. FACADE DP :- It gives more simplified interface for complex system or view of the complex environment.

When to use? -  Overall facade pattern is valuable whenever you need to hide complexity, simplify interactions,
  improve maintainability.

-> Here Multimedia player acts as facade to client. we can access or operate Subsystems(Audio Player, Video Player)
   with help of Multimedia Player Facade.
   
3. DECORATOR DP :- Decorator is a structural design pattern that lets you attach new behaviors to objects by placing
                   these objects inside special wrapper objects that contain the behaviors.

-> For example a person is working in ice cream store, and he has to prepare ice cream based on user requirements.
-> There could be multiple flavours of each ingredient.
   Cones -> Mango cone, chocolate cone, some other cones and each cone has different price.
   Scoops -> MangoScope, Strawberry scope, Chocolate Scoop etc. each scoop has different price.
   Syrups -> Strawberry syrup, Chocolate syrup, Mango syrup etc. each syrup has different price.
   Chips -> Choco chips, etc. each chip has different price.
-> Now we have to prepare ice cream on user requirement and print bill.
-> We can't create classes for multiple combinations.
   flavours of cone * flavours of scoops * flavours of syrups * flavours of chips
   It leads to class explosion.




BEHAVIOURAL DESIGN PATTERNS :
1. STRATEGY DP :
-> It lets you define multiple algorithms, put each of them into separate class and make them interchangeable.

Version 1 :
-> In this example we are going write code for different modes of map in same class.
-> If mode = walk, we get walk route in maps
-> But it is violating SRP and OCP Principles
-> SRP : getRoute method has to get route only, but it is doing more than getRoute
-> OCP : We can add new feature in future or can extend but in order to extend we have to modify existing code.

When OCP violates we use override, think in that way...
yes we write code in different classes for different modes.

Version 2 :
-> We write code in different classes for different strategies.
-> It's easy to switch between different algorithms, it makes code more flexible.
-> Adding new algorithm is very easy.

2. OBSERVER DP :-
-> Observer is a behavioral design pattern that lets you define a subscription mechanism to notify multiple objects about any events that happen to the object they’re observing.

When to use?
-> When multiple objects observing an object, If any event occurs to object then the objects should get notified.

Example :
You are developing a stock trading platform where users need to be notified
whenever the price of a particular stock crosses a certain threshold.
These notifications should be sent through various channels such as email, SMS, and mobile app notifications.
To achieve this, you want to implement the Observer pattern,
allowing users to subscribe to stock price updates and receive notifications through multiple channels.


-> Here users get notified when stock price goes beyond threshold price and users should get notified by different notification channels.
-> So here observers are Notification channels(AppService, SMSService, EmailService), These channels should get notified and
   will send notification to all users.
-> Observers will go to publisher and register themselves to get notified.
-> When stock price goes beyond threshold price, publisher will notify all observers that are registered earlier.
-> There could be multiple observers so make them implement common interface.
-> As well There could be multiple publishers, so make them implement common interface.
