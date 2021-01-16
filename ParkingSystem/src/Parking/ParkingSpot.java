package Parking;

public class ParkingSpot {
    private String parkingSpotId;
    private boolean free;
    private VehicleForParking parkedVehicle;

    public ParkingSpot(String parkingSpotId) {
        this.parkingSpotId = parkingSpotId;
        this.free = true;
    }
    
    public void assignVehicle(VehicleForParking vp){
        this.free = false;
        this.parkedVehicle = vp;
    }
    
    public void removeVehicle(){
        this.free = true;
        this.parkedVehicle = null;
    }

    public boolean isFree() {
        return free;
    }

    public VehicleForParking getParkVehicle() {
        return parkedVehicle;
    }

    
    @Override
    public String toString() {
        return "ParkingSpot{" + "parkingSpotId=" + parkingSpotId + ", free=" + free + 
                (free?"" : "vehicle=" + parkedVehicle)
                + '}';
    }
    
}
