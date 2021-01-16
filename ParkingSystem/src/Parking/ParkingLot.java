package Parking;

public class ParkingLot {

    //aggregation and composition
    private ParkingSpot parkingSpots[];
    public int count;

    public ParkingLot(int maximumCapacity) {
        parkingSpots = new ParkingSpot[maximumCapacity];
        createParkingSpot();
    }

    private void createParkingSpot() {
        for (int i = 0; i < parkingSpots.length; i++) {
            parkingSpots[i] = new ParkingSpot(i + 1 + "a");
        }
    }

    public void entryPoint(VehicleForParking vp) {
        //check free spot
        int freeSpot = checkFreeSpot();
        if (freeSpot == -1) {
            System.out.println("Parking Lot is Full!!!");
        } else {
            //receive Ticket

            //if spot is free,call spot to assign vehicle
            parkingSpots[freeSpot].assignVehicle(vp);
            count++;

        }
    }

    public int searchVehicleParkingSpot(VehicleForParking vp){
        for (int i = 0; i < parkingSpots.length; i++) {
            if(vp.getVehicle().equals(parkingSpots[i].getParkVehicle().getVehicle()))
                return i;
        }
        return -1;
    }
    
    public void exitPoint(VehicleForParking vp) {
        int foundParkedVehicle = searchVehicleParkingSpot(vp);
        parkingSpots[foundParkedVehicle].removeVehicle();
        count--;
    }

    public int checkFreeSpot() {
        if (count == parkingSpots.length) {
            return -1;
        }
        for (int i = 0; i < parkingSpots.length; i++) {
            if (parkingSpots[i].isFree()) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < parkingSpots.length; i++) {
            str.append(parkingSpots[i]);
        }
        return str.toString();
    }

}
