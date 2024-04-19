package CreationalDesignPatterns.BuiderPattern.production;

/*
 In order to create Student object, we have to create with help of builder of student.
 How do we get builder of student? -> yes, student has static getBuilder method, call it to get builder obj.
 Builder has same properties of student. So, use set methods of builder to initialise student attributes.
 Once set all attributes, now call build method of builder it builds student object, while. it builds it checks
 given conditions, if it satisfies then only it creates object.
 */
public class Student1 {
    String name;
    String email;
    int age;
    String phoneNumber;

    private Student1(Builder b){
//        this.name = b.name;
//        this.email = b.email;
//        this.age = b.age;
//        this.phoneNumber = b.phoneNumber;
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
