package com.shashank.ps.lld.parkingLot;

public class ParkingLotOperations {
    public Slot requestSlot(Vehicle vehicle) {
        // Method to request any available slot for the vehicleType.

        // Returns null if no slot available
        return null;
    }

    public void park(Vehicle vehicle) {
        // Make the slot allocated to unavailable for any other use.
    }

    public void removeVehicle(Vehicle vehicle) {
        // Frees up the allocated slot for other's use.
    }

    public double calculateFare(Vehicle vehicle) {
        // Computes the fare for the parked vehicle once it's ready to leave.

        return 0.0;
    }
}
