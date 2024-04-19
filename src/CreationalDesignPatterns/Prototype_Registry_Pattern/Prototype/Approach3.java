package CreationalDesignPatterns.Prototype_Registry_Pattern.Prototype;

import java.util.Random;

/*
Copy Constructor Approach
-> In this approach, we copy the object through constructor.

Pros :
-> No code duplication.
-> Easy to manage new attributes.
-> Private attributes can be copied.

Cons : SRP & OCP violation.

 */
public class Approach3 {
    public static void main(String[] args) {
        Student s = new Student("sagar", 25, "CSE");
        System.out.println(s.toString());

        IntelligentStudent is = new IntelligentStudent("Bhavik", 25, "IT", 98);
        System.out.println(is.toString());



        Student s1 = null;
        Random r = new Random();
        int num = r.nextInt();

        System.out.println(num);

        if(num % 2 == 0) s1 = new Student();
        else s1 = new IntelligentStudent();

        // Copy object of S1. before copying check s1 is which object.
        Student copy = new Student();
        if(s1 instanceof IntelligentStudent) copy = new IntelligentStudent(is);
        else copy = new Student(s);

        /*
          The above code violates SRP and OCP rules
          SRP -> It has to copy the object only, but it does more than that(checking instance)
          OCP -> If a class extends student we need to change the above code(need to add one more if else)
         */

        System.out.println(copy.toString());

    }
}
