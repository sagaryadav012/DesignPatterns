package BehaviouralDesignPatterns.StrategyDP.Example2;

public class NonePaidUser implements SubscriptionStrategy{

    @Override
    public void videoStream() {
        System.out.println("Streaming video in 480p");
    }
}
