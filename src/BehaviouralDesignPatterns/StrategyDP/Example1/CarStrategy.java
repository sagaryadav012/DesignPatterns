package BehaviouralDesignPatterns.StrategyDP.Example1;

public class CarStrategy implements RouteStrategy{
    @Override
    public void buildRoute(int src, int dest) {
        System.out.println("Going by Car");
    }
}
