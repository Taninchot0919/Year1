package Parking;

import Vehicle.Vehicle;

public class VehicleForParking {

    private ParkingTicket parkingTicket;
    private Vehicle vehicle;

    public VehicleForParking(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    @Override
    public String toString() {
        return "VehicleForParking{" + "parkingTicket=" + parkingTicket + ", vehicle=" + vehicle + '}';
    }

}
