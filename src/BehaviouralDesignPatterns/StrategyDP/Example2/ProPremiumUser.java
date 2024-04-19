package BehaviouralDesignPatterns.StrategyDP.Example2;

public class ProPremiumUser implements SubscriptionStrategy{
    @Override
    public void videoStream() {
        System.out.println("Streaming video in 2160p");
    }
}
