package CreationalDesignPatterns.Prototype_Registry_Pattern.Prototype;

/*
This is class created as example for approach 4
-> In this we override, clone method where we do copy constructor approach
 */
public class IntelligentStudentEx extends StudentEx{
    int marks;
    public IntelligentStudentEx(String name, int age, String branch, int marks){
        super(name, age, branch);
        this.marks = marks;
    }

    public IntelligentStudentEx(IntelligentStudentEx original){
        super(original);
        this.marks = original.marks;
    }

    public IntelligentStudentEx clone() throws CloneNotSupportedException{
        return new IntelligentStudentEx(this);
    }
}
