package vehicle;

import parking.ParkingTicket;

public class VehicleForParking extends Vehicle {

    private ParkingTicket parkingTicket;

    public VehicleForParking(String licensePlate, VehicleType vehicleType) {
        super(licensePlate, vehicleType );
    }

    public void assignTicket() {
        this.parkingTicket=new ParkingTicket();
        this.parkingTicket.issuedAt();
    }

    public void returnTicket() {
        this.parkingTicket.payedAt();
    }

    @Override
    public String toString() {
        return  super.toString()+parkingTicket.toString() ;
    }
    
    
}
