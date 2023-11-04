package com.shashank.ps.lld.trafficLightManagement;

public interface TrafficControlSystem {
    public void addVehicle(Vehicle vehicle);
    public void updateTrafficLight() throws InterruptedException;
}
