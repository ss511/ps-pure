package com.shashank.ps.lld.trafficLightManagement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrafficControlSystemSchedule implements TrafficControlSystem {
    private Intersection intersection;
    List<Vehicle> vehicleList;

    public void addVehicle(Vehicle vehicle) {
        vehicleList.add(vehicle);
    }

    public void updateTrafficLight() throws InterruptedException {
        for (Direction direction: Direction.values()) {
            intersection.controlTraffic(direction);
            Thread.sleep(60000);
            TrafficManagement trafficManagement = TrafficManagement.getTrafficManagement();
            if (!trafficManagement.getTrafficManagementType().equals(TrafficManagementType.SCHEDULE)) {
                break;
            }
        }
    }
}
