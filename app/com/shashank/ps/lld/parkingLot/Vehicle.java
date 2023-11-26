package com.shashank.ps.lld.parkingLot;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehicle {
    private String licensePlate;
    private String color;
    private VehicleType vehicleType;
    private SlotType requiredSlotType;
}
