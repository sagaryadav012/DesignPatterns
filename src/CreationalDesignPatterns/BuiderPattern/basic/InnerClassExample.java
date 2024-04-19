package CreationalDesignPatterns.BuiderPattern.basic;

public class InnerClassExample {
    public static void main(String[] args) {
        // call the inner class object
        A.B b = new A().new B();

        // call the static inner class object
        A.C c = new A.C();
    }
}

class A{
    int a = 10;
    class B{
        String name = "some";
    }
    static class C{
        double d = 0.00;
    }
}
