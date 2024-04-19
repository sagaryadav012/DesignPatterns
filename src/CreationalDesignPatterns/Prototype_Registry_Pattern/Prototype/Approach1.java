package CreationalDesignPatterns.Prototype_Registry_Pattern.Prototype;
/*
   Shallow Copy
-> In this approach we just copy only reference points to already created object.

Pros : Easy to copy.
Cons : It leads to bugs, if we change something in object, all instances points to this object will get effected.
 */
public class Approach1 {
    public static void main(String[] args) {
        Student s = new Student();
        s.name = "sagar";
        s.age = 25;


        Student s1 = s;
        s1.name = "Bhavik";

        System.out.println(s.toString());
        System.out.println(s1.toString());
    }
}
