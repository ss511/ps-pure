package com.shashank.ps.lld.trafficLightManagement;

import java.util.List;

public class TrafficControlSystemManual implements TrafficControlSystem{
    private Intersection intersection;
    List<Vehicle> vehicleList;
    private Direction direction;

    public void addVehicle(Vehicle vehicle) {
        vehicleList.add(vehicle);
    }

    public void updateDirection(Direction direction) {
        this.direction = direction;
    }

    public void updateTrafficLight() throws InterruptedException {
        intersection.controlTraffic(direction);
    }
}
