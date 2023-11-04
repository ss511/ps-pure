package com.shashank.ps.lld.trafficLightManagement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehicle {
    private VehicleType vehicleType;
    private Direction direction;

    public Vehicle(VehicleType vehicleType, Direction direction) {
        this.vehicleType = vehicleType;
        this.direction = direction;
    }
}
