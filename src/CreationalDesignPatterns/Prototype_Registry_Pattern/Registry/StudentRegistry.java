package CreationalDesignPatterns.Prototype_Registry_Pattern.Registry;

import CreationalDesignPatterns.Prototype_Registry_Pattern.Prototype.StudentEx;

import java.util.HashMap;
import java.util.Map;

/*
   We created object of StudentRegistry and registered or stored some objects in StudentRegistry obj.
   When we get objects from StudentRegistry we need to call get method of StudentRegistry, to call method
   We need object. So if create new object of StudentRegistry, will it have objects that we have stored earlier?
   No right? So there should be only one object exists.
   So StudentRegistry class should be singleton.
*/
public class StudentRegistry {
    // To hold objects we need map
    Map<String, StudentEx> map = new HashMap<>();

    private StudentRegistry(){
        map = new HashMap<>();
    }

    private static StudentRegistry INSTANCE = null;
    public static StudentRegistry getInstance(){
        if(INSTANCE == null){
            INSTANCE = new StudentRegistry();
        }
        return INSTANCE;
    }

    public void register(String key, StudentEx studentEx){
        map.put(key, studentEx);
    }

    public StudentEx get(String key){
        return map.get(key);
    }
}
