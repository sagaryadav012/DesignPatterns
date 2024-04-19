package CreationalDesignPatterns.Prototype_Registry_Pattern.Prototype;

/*
This is class created as example for approach 4
-> In this we override, clone method where we do copy constructor approach
 */
public class StudentEx {
    String name;
    private int age;
    String branch;

    public StudentEx(String name, int age, String branch){
        this.name = name;
        this.age = age;
        this.branch = branch;
    }

    public StudentEx(StudentEx original){
        this.name = original.name;
        this.age = original.age;
        this.branch = original.branch;
    }

    public StudentEx clone() throws CloneNotSupportedException{
        return new StudentEx(this);
    }
}
