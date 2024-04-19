package CreationalDesignPatterns.Prototype_Registry_Pattern.Prototype;

public class Student {
    String name;
    int age;
    private String branch;

    public Student(){

    }
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
    @Override
    public String toString() {
        return "Name : "+ this.name +" Age : "+ this.age +" branch :" + this.branch;
    }
}
