package BehaviouralDesignPatterns.StrategyDP.Example1;

/*
In this version we write code logic for different modes in different classes

 */
public class GoogleMaps_Vers2 {
    public static void main(String[] args) {
        getRoute(5, 10, Mode.WALK);
    }
    public static void getRoute(int src, int dest, Mode mode){
        RouteStrategy routeStrategy = getRouteStrategy(mode);
        routeStrategy.buildRoute(src, dest);
    }
    public static RouteStrategy getRouteStrategy(Mode mode){
        if(mode == Mode.WALK) return new WalkStrategy();
        if(mode == Mode.BIKE) return new BikeStrategy();
        if(mode == Mode.CAR) return new CarStrategy();
        return null;
    }
}
/*
Strategy DP : It lets you define multiple algorithms, put each of them into separate class and make them interchangeable.

Version 1 :
-> In this example we are going write code for different modes of map in same class.
-> If mode = walk, we get walk route in maps
-> But it is violating SRP and OCP Principles
-> SRP : getRoute method has to get route only, but it is doing more than getRoute
-> OCP : We can add new feature in future or can extend but in order to extend we have to modify existing code.

When OCP violates we use override, think in that way...
yes we write code in different classes for different modes.

Version 2 :
-> We write code in different classes for different strategies.
-> It's easy to switch between different algorithms, it makes code more flexible.
-> Adding new algorithm is very easy.

 */