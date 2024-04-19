package CreationalDesignPatterns.Prototype_Registry_Pattern.Prototype;

public class IntelligentStudent extends Student{
    int marks;

    IntelligentStudent(){}

    public IntelligentStudent(String name, int age, String branch, int marks){
        super(name, age, branch);
        this.marks = marks;
    }

    public IntelligentStudent(IntelligentStudent original){
        super(original);
        this.marks = original.marks;
    }

    @Override
    public String toString() {
        return super.toString() + " Marks :" + this.marks;
    }
}
