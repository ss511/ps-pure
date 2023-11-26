package com.shashank.ps.lld.parkingLot;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
public class Level {
    private int floorNumber;
    private List<Slot> slots;
    private Map<SlotType, Long> availableSlotsByTypes;
    private Map<SlotType, Long> totalSlotsByTypes;
}


