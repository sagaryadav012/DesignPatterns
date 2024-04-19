package BehaviouralDesignPatterns.StrategyDP.Example1;
/*
In this example we are going write code for different modes of map
If mode = walk, we get walk route in maps
But it is violating SRP and OCP Principles
SRP -> getRoute method has to get route only, but it is doing more than getRoute
OCP -> We can add new feature in future or can extend but in order to extend we have to modify existing code.

When OCP violates we use override, think in that way...
yes we write code in different classes for different modes..
 */
public class GoogleMaps_Vers1 {
    public static void main(String[] args) {
        getRoute(0, 10, Mode.BIKE);
    }
    public static void getRoute(int src, int des, Mode mode){
        if(mode == Mode.WALK){
            System.out.println("Can go by WALK");
        }
        else if(mode == Mode.CAR){
            System.out.println("Can go by CAR");
        }
        else if(mode == Mode.BIKE){
            System.out.println("Can go by BIKE");
        }
    }
}
