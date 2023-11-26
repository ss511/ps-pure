package com.shashank.ps.lld.parkingLot;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Slot {
    private SlotType slotType;
    private Integer number;
    private boolean isAvailable;
    private Vehicle parkedVehicle;

    public void removeVehicle() {
        this.parkedVehicle = null;
        this.isAvailable = true;
    }
}
