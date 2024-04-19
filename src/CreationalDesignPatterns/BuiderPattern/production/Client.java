package CreationalDesignPatterns.BuiderPattern.production;

import CreationalDesignPatterns.BuiderPattern.production.Student;

public class Client {
    public static void main(String[] args) throws Exception {
//        Student.Builder sb = new Student.Builder();
//        sb.setAge(20);
//        sb.setName("sagar");
//        sb.setEmail("s@yadav.com");
//        //     b.setPhoneNumber("+12345");
//
//        Student s = new Student(sb);
//        System.out.println(s.toString());

        Student1 s = Student1.getBuilder().setAge(18)
                .setName("sagar")
                .setEmail("s@yadav.com")
                .setPhoneNumber("+123456")
                .build();
        System.out.println(s.toString());
        System.out.println(s.name+" "+s.email);
    }
}

/*
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
}
 */