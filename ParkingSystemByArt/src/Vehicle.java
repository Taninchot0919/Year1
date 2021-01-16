
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author taninchot
 */
public class Vehicle {
    private String licenseNumber;
    private VehicleType type;

    public Vehicle(String licenseNumber, VehicleType type) {
        this.licenseNumber = licenseNumber;
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
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
        if (!Objects.equals(this.licenseNumber, other.licenseNumber)) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        return true;
    }

   

    @Override
    public String toString() {
        return "Vehicle{" + "licenseNumber=" + licenseNumber + ", type=" + type + '}';
    }
    
    
}
