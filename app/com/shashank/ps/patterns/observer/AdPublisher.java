package com.shashank.ps.patterns.observer;

import java.util.HashSet;
import java.util.Set;

public class AdPublisher {

    private Channel channel;

    private String adName;

    private Set<Channel> channelSubscription = new HashSet<>();

    public void subscribeForAds(Channel channel) {
        channelSubscription.add(channel);
    }

    public void removeSubscription(Channel channel) {
        channelSubscription.remove(channel);
    }

    public void publishAd() {
        channelSubscription.forEach(channel1 -> {
            channel1.update(adName);});
    }

    public void setAdName(String adName) {
        this.adName = adName;
        publishAd();
    }
}
