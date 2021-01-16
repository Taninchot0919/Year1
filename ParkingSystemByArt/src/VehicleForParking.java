/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author taninchot
 */
public class VehicleForParking extends Vehicle{
    private ParkingTicket parkingTicket;

    public VehicleForParking(String licensePlate, VehicleType vehicleType){
        super(licensePlate,vehicleType);
    }
    
    public void assignTicket(){
        parkingTicket.issueAt();
    }
    public void returnTicket(){
        parkingTicket.payedAt();
        parkingTicket.calculateParkingHours();
    }

    @Override
    public String toString() {
        return "VehicleForParking{" + "parkingTicket=" + parkingTicket + '}';
    }
    
}
