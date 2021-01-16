/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author taninchot
 */
public class ParkingSpot {

    private String parkingSpotId;
    private boolean free;
    private VehicleForParking vehicle;

    public ParkingSpot(String parkingSpotId) {
        this.parkingSpotId = parkingSpotId;
    }

    public void assignVehicle(VehicleForParking vehicle) {
        if (isFree() == true) {
            this.vehicle = vehicle;
            this.free = false;
            vehicle.assignTicket();
        } else {
            System.out.println("Can't add");
        }
    }

    public boolean isFree() {
        return free;
    }

    public VehicleForParking getVehicle() {
        return vehicle;
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.free = true;
        vehicle.returnTicket();
    }

    @Override
    public String toString() {
        return "ParkingSpot{" + "parkingSpotId=" + parkingSpotId + ", free=" + free + ", vehicle=" + vehicle + '}';
    }

}
