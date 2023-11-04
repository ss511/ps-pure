package com.shashank.ps.lld.trafficLightManagement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrafficLight {
    private Color color;

    public TrafficLight() {
        this.color = Color.RED;
    }

    public TrafficLight(Color color) {
        this.color = color;
    }
}
