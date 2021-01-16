/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author taninchot
 */
public class ParkingLot {

    public final int parking_rate = 20;
    private ParkingSpot[] parkingSpot;
    private int count;

    public ParkingLot(int maxCapacity) {
        if(maxCapacity <= 0){
            parkingSpot = new ParkingSpot[10];
        }
        parkingSpot = new ParkingSpot[maxCapacity];
    }

    public void createParkingSpot() {

    }

    public void entryPoint(VehicleForParking vehicle) {
        int slot = getAvailableParkingSpot();
        if (slot == -1) {
            System.out.println("Can't Add");
        } else {
            parkingSpot[slot].assignVehicle(vehicle);
            count++;
        }

    }

    public void exitPoint(VehicleForParking vehicle) {
        int foundVehicle = searchVehicleInParkingSpot(vehicle);
        if(foundVehicle == -1){
            System.out.println("Can't Add");
        }else{
            parkingSpot[foundVehicle].removeVehicle();
            count--;
        }
    }

    public int searchVehicleInParkingSpot(VehicleForParking vehicle) {
        for (int i = 0; i < parkingSpot.length; i++) {
            if (parkingSpot[i] == null) {
                continue;
            } else if (parkingSpot[i].equals(vehicle)) {
                return i;
            }
        }
        return -1;
    }

    public int getAvailableParkingSpot() {
        for (int i = 0; i < parkingSpot.length; i++) {
            if (parkingSpot[i] == null) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "ParkingLot{" + "parking_rate=" + parking_rate + ", parkingSpot=" + parkingSpot + ", count=" + count + '}';
    }

}
