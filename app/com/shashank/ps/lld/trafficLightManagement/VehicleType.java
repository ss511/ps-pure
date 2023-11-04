package com.shashank.ps.lld.trafficLightManagement;

import java.util.HashMap;
import java.util.Map;

public enum VehicleType {
    PRIVATE, PUBLIC, LAW_ENFORCEMENT, EMERGENCY_SERVICES;

    public Map<VehicleType, Integer> getVehiclePriorityMap() {
        Map<VehicleType, Integer> priority = new HashMap<>();
        priority.put(PRIVATE, 1);
        priority.put(PUBLIC, 10);
        priority.put(LAW_ENFORCEMENT, 100);
        priority.put(EMERGENCY_SERVICES, 110);

        return priority;
    }
}
