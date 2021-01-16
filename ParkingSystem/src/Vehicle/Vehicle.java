package Vehicle;

import java.util.Objects;

public abstract class Vehicle {

    private String licensePlate;

    public Vehicle(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
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
        if (!Objects.equals(this.licensePlate, other.licensePlate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "licensePlate=" + licensePlate + '}';
    }

}
