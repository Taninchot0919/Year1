package vehicle;

import java.util.Objects;
import parking.ParkingTicket;
import vehicle.VehicleType;

public class Vehicle {
    private String licensePlate;
    private final VehicleType vehicleType;

    public Vehicle(String licensePlate, VehicleType vehicleType) {
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;

    }

    @Override
    public boolean equals(Object obj) {
       
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehicle other = (Vehicle) obj;
        if (!Objects.equals(this.licensePlate, other.licensePlate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "licensePlate=" + licensePlate
         + ", vehicleType=" + vehicleType + '}';
    }

}
