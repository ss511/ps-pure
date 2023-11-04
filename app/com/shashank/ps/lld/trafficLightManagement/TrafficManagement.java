package com.shashank.ps.lld.trafficLightManagement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TrafficManagement {

    private static TrafficManagement trafficManagement = null;
    private TrafficManagementType trafficManagementType;

    private TrafficManagement() {
        this.trafficManagementType = TrafficManagementType.SCHEDULE;
    }

    public static TrafficManagement getTrafficManagement() {
        if (trafficManagement == null) {
            trafficManagement = new TrafficManagement();
        }
        return trafficManagement;
    }

}
