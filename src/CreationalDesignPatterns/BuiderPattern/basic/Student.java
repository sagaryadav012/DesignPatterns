package CreationalDesignPatterns.BuiderPattern.basic;

public class Student {
    String name;
    String email;
    int age;
    String phoneNumber;

    public Student(Builder b) throws Exception{
        if(b.age < 18){
            throw new Exception("Age cannot be less than 18");
        }
        this.age = b.age;
        this.name = b.name;
        this.email = b.email;
        this.phoneNumber = b.phoneNumber;
    }

}
