package com.shashank.ps.lld.parkingLot;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConstructParkingLot implements Cloneable {

    private ConstructParkingLot() {}

    public static List<Level> getParkingLotLevels() {
        List<Level> levels = new ArrayList<>();
        List<Slot> slots1 = constructSlot();
        Map<SlotType, Long> totalSlotsForLevel1 = fetchTotalSlotDetails(slots1);
        Map<SlotType, Long> availableSlotsForLevel1 = fetchAvailableSlotDetails(totalSlotsForLevel1);

        Level level1 = Level.builder()
                .floorNumber(1)
                .slots(slots1)
                .totalSlotsByTypes(totalSlotsForLevel1)
                .availableSlotsByTypes(availableSlotsForLevel1)
                .build();

        levels.add(level1);

        List<Slot> slots2 = constructSlot();
        Map<SlotType, Long> totalSlotsForLevel2 = fetchTotalSlotDetails(slots2);
        Map<SlotType, Long> availableSlotsForLevel2 = fetchAvailableSlotDetails(totalSlotsForLevel2);

        Level level2 = Level.builder()
                .floorNumber(2)
                .slots(slots1)
                .totalSlotsByTypes(totalSlotsForLevel2)
                .availableSlotsByTypes(availableSlotsForLevel2)
                .build();

        levels.add(level2);

        List<Slot> slots3 = constructSlot();
        Map<SlotType, Long> totalSlotsForLevel3 = fetchTotalSlotDetails(slots3);
        Map<SlotType, Long> availableSlotsForLevel3 = fetchAvailableSlotDetails(totalSlotsForLevel3);

        Level level3 = Level.builder()
                .floorNumber(1)
                .slots(slots1)
                .totalSlotsByTypes(totalSlotsForLevel3)
                .availableSlotsByTypes(availableSlotsForLevel3)
                .build();

        levels.add(level3);
        return levels;
    }

    private static List<Slot> constructSlot() {
        List<Slot> slots = new ArrayList<>();
        Slot slot1 = Slot.builder()
                .slotType(SlotType.EV_4)
                .isAvailable(true)
                .number(1)
                .parkedVehicle(null)
                .build();

        Slot slot2 = Slot.builder()
                .slotType(SlotType.EV_2)
                .isAvailable(true)
                .number(2)
                .parkedVehicle(null)
                .build();

        Slot slot3 = Slot.builder()
                .slotType(SlotType.General_4)
                .isAvailable(true)
                .number(3)
                .parkedVehicle(null)
                .build();

        Slot slot4 = Slot.builder()
                .slotType(SlotType.General_4)
                .isAvailable(true)
                .number(4)
                .parkedVehicle(null)
                .build();

        Slot slot5 = Slot.builder()
                .slotType(SlotType.General_2)
                .isAvailable(true)
                .number(5)
                .parkedVehicle(null)
                .build();

        Slot slot6 = Slot.builder()
                .slotType(SlotType.General_2)
                .isAvailable(true)
                .number(6)
                .parkedVehicle(null)
                .build();

        Slot slot7 = Slot.builder()
                .slotType(SlotType.General_2)
                .isAvailable(true)
                .number(7)
                .parkedVehicle(null)
                .build();

        Slot slot8 = Slot.builder()
                .slotType(SlotType.Special_Needs)
                .isAvailable(true)
                .number(8)
                .parkedVehicle(null)
                .build();

        slots.add(slot1);
        slots.add(slot2);
        slots.add(slot3);
        slots.add(slot4);
        slots.add(slot5);
        slots.add(slot6);
        slots.add(slot7);
        slots.add(slot8);

        return slots;
    }

    private static Map<SlotType, Long> fetchTotalSlotDetails(List<Slot> slots) {
        return slots.stream()
                .collect(Collectors.groupingBy(Slot::getSlotType, Collectors.counting()));
    }

    private static Map<SlotType, Long> fetchAvailableSlotDetails(Map<SlotType, Long> totalSlotDetail) {
        return new HashMap<>(totalSlotDetail);
    }

    @Override
    public ConstructParkingLot clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
