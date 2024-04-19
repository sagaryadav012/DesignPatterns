package CreationalDesignPatterns.BuiderPattern.basic;

public class Client {
    public static void main(String[] args) throws Exception {
        Builder b = new Builder();
        b.setAge(20);
        b.setName("sagar");
        b.setEmail("s@yadav.com");
   //     b.setPhoneNumber("+12345");

        Student s = new Student(b);

        System.out.println(s.toString());
    }
}
