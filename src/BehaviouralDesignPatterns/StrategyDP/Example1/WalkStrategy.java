package BehaviouralDesignPatterns.StrategyDP.Example1;

public class WalkStrategy implements RouteStrategy{
    @Override
    public void buildRoute(int src, int dest) {
        System.out.println("Going By Walk");
    }
}
