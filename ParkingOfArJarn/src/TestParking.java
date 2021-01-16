import parking.ParkingLot;
import vehicle.VehicleForParking;
import vehicle.VehicleType;

public class TestParking {

    public static void main(String[] args) {
       
        ParkingLot lot = new ParkingLot(2);
        VehicleForParking car1 = new VehicleForParking("SE-1234", VehicleType.CAR);
                
        lot.entryPoint(car1);
        System.out.println("---after add vehicle(car)#1---\n" + lot);
        
        VehicleForParking van2 = new VehicleForParking("SE-1235", VehicleType.VAN);
        lot.entryPoint(van2);
        System.out.println("---after add vehicle(van)#2---\n" + lot);
              
        System.out.println("---at exit point: vehicle(car)#1---");
        lot.exitPoint(car1);
        
        System.out.println("---after remove vehicle(car)#1---\n" + lot);
        
        VehicleForParking car3 = new VehicleForParking("SE-1237", VehicleType.CAR);
        lot.entryPoint(car3);
        System.out.println("---after add vehicle(car)#3---\n" + lot);
    
        System.out.println("---at exit point: vehicle(van)#2---");
        lot.exitPoint(van2);
      
        System.out.println("---after remove vehicle(van)#2---\n" + lot);
       
    }
}
