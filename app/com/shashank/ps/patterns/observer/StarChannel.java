package com.shashank.ps.patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class StarChannel implements Channel{

    private final List<String> ads = new ArrayList<>();
    @Override
    public void update(String adName) {
        ads.add(adName);
        System.out.println("New Ad added in Star Channel. All available ads are: ");
        listAds();
    }

    public void listAds() {
        System.out.println(ads);
    }
}
