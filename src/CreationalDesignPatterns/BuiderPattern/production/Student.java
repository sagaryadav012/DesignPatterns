package CreationalDesignPatterns.BuiderPattern.production;

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

    static class Builder{
        String name;
        String email;
        int age;
        String phoneNumber;

        public void setName(String name) {
            this.name = name;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
    }
}
