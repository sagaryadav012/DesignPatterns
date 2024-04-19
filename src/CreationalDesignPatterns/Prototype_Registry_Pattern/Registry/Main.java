package CreationalDesignPatterns.Prototype_Registry_Pattern.Registry;

import CreationalDesignPatterns.Prototype_Registry_Pattern.Prototype.IntelligentStudentEx;
import CreationalDesignPatterns.Prototype_Registry_Pattern.Prototype.StudentEx;

public class Main {
    public static final String STUDENT_KEY = "STUDENT";
    public static final String INTELLIGENT_STUDENT = "INTELLIGENT_STUDENT";
    public static void setupRegistry(){
        StudentRegistry studentRegistry = StudentRegistry.getInstance();
        StudentEx prototypeStudentEx = new StudentEx("Sagar", 25, "CSE");
        IntelligentStudentEx prototypeIntelligentStudentEx = new IntelligentStudentEx("Bhavik", 25, "IT", 98);

        studentRegistry.register(STUDENT_KEY, prototypeStudentEx);
        studentRegistry.register(INTELLIGENT_STUDENT, prototypeIntelligentStudentEx);

//        System.out.println(prototypeStudentEx);
//        System.out.println(prototypeIntelligentStudentEx);
    }

    public static void main(String[] args) {
        setupRegistry();
        StudentRegistry studentRegistry = StudentRegistry.getInstance();
        StudentEx studentEx = studentRegistry.get(STUDENT_KEY);
        IntelligentStudentEx  intelligentStudentEx = (IntelligentStudentEx) studentRegistry.get(INTELLIGENT_STUDENT);

//        System.out.println(studentEx);
//        System.out.println(intelligentStudentEx);
    }
}
