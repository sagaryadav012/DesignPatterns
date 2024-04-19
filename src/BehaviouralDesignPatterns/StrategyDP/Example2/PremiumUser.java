package BehaviouralDesignPatterns.StrategyDP.Example2;

public class PremiumUser implements SubscriptionStrategy{
    @Override
    public void videoStream() {
        System.out.println("Streaming video in 1080p");
    }
}
