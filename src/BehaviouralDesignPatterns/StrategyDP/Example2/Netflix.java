package BehaviouralDesignPatterns.StrategyDP.Example2;

public class Netflix {
    public static void main(String[] args) {
        playVideo(Subscription.PROPREMIUM);
    }
    public static void playVideo(Subscription subscription){
        SubscriptionStrategy subscriptionStrategy = getSubscriptionLevel(subscription);
        subscriptionStrategy.videoStream();
    }
    public static SubscriptionStrategy getSubscriptionLevel(Subscription sub){
        if(sub == Subscription.NONE) return new NonePaidUser();
        if(sub == Subscription.PREMIUM) return new PremiumUser();
        if(sub == Subscription.PROPREMIUM) return new ProPremiumUser();
        return null;
    }
}
