package CreationalDesignPatterns.BuiderPattern.basic;

public class Builder {
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
