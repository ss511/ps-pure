package com.shashank.ps.patterns.observer;

public class ObserverRunner {

    public static void main(String[] args) {

        Channel star = new StarChannel();
        Channel eureka = new EurekaChannel();

        AdPublisher adPublisher = new AdPublisher();
        adPublisher.subscribeForAds(star);

        adPublisher.setAdName("Dark Chocolate");

        adPublisher.subscribeForAds(eureka);

        adPublisher.setAdName("Sports Car");

        adPublisher.removeSubscription(star);

        adPublisher.setAdName("Smartphone");
    }
}
