package com.shashank.ps.lld.trafficLightManagement;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TrafficControlSystemVolume implements TrafficControlSystem {
    private Intersection intersection;
    List<Vehicle> vehicles;

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void updateTrafficLight() throws InterruptedException {
        while (true) {
            Map<Direction, Long> countByDirection = vehicles.stream()
                    .collect(Collectors.groupingBy(Vehicle::getDirection, Collectors.counting()));

            Direction directionWithMostVehicles = countByDirection.entrySet().stream()
                    .max(Map.Entry.comparingByValue())
                    .map(Map.Entry::getKey)
                    .orElse(null);

            intersection.controlTraffic(directionWithMostVehicles);
            Thread.sleep(60000);
            TrafficManagement trafficManagement = TrafficManagement.getTrafficManagement();
            if (!trafficManagement.getTrafficManagementType().equals(TrafficManagementType.VOLUME)) {
                break;
            }
        }
    }
}
