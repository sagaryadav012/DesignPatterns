package BehaviouralDesignPatterns.StrategyDP.Example1;

public class BikeStrategy implements RouteStrategy{
    @Override
    public void buildRoute(int src, int dest) {
        System.out.println("Going by Bike");
    }
}
