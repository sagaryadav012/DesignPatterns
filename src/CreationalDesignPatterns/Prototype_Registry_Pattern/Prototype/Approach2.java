package CreationalDesignPatterns.Prototype_Registry_Pattern.Prototype;

/*
  Deep Copy Approach
-> In this approach, we copy object manually.

Pros : It will work in most of the cases.
Cons :
-> Every time we need to copy, we will need to duplicate the code.
-> New attributes handling is difficult means if we add new attributes in Student, we need copy new attributes,
   so we have to change code where we performed copying.
-> Private attributes cannot be copied.


 */
public class Approach2 {
    public static void main(String[] args) {
        Student s = new Student();
        s.age = 25;
        s.name = "sagar";

        Student s1 = new Student();
        s1.age = s.age;
        s1.name = s.name;

        s1.name = "Bhavik";

        // s.branch : Can't access private attributes

        System.out.println(s.toString());
        System.out.println(s1.toString());
    }
}
