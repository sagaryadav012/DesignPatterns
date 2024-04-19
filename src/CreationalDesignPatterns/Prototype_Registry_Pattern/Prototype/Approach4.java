package CreationalDesignPatterns.Prototype_Registry_Pattern.Prototype;

/*
Prototype : copy the existing object rather than creating another from scratch, something that may include
            costly operation.

Clone approach :
-> In this approach, we override clone method of object where we pass copy constructor method
-> In main function, we call clone method of object(object can vary)

How singleton is different from prototype?
-> In singleton we only create one object throughout the application.
-> In prototype, we copy object means it creates another object.
 */

import java.util.Random;

public class Approach4 {
    public static void main(String[] args) throws CloneNotSupportedException{
       StudentEx instance = getInstance();
       System.out.println(instance);

       StudentEx copy = null;

       try {
           copy = instance.clone();
       }catch (CloneNotSupportedException ex){
           System.out.println(ex.getMessage());
       }

        System.out.println(copy);
    }
    public static StudentEx getInstance(){
        Random r = new Random();
        int num = r.nextInt(1000);
        System.out.println(num);

        StudentEx instance = null;
        if(num % 2 == 0){
            instance = new StudentEx("sagar", 25, "CSE");
        }else{
            instance = new IntelligentStudentEx("Bhavik", 25, "IT", 98);
        }

        return instance;
    }
}
/*

Prototype Design Pattern :
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

 */