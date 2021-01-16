/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.House;

import java.util.Objects;

/**
 *
 * @author Laptop
 */
public class House {

    private int HouseID;
    private String nameOfHouse;
    private String typeofHouse;
    private double price;
    private String houseStatus;

    public House() {
    }

    public House(int HouseID, String nameOfHouse, String typeofHouse, double price) {
        this.HouseID = HouseID;
        this.nameOfHouse = nameOfHouse;
        this.typeofHouse = typeofHouse;
        this.price = price;
        this.houseStatus = HouseStatus.AVALIABLE.toString();
    }

    

    public int getHouseID() {
        return HouseID;
    }

    public String getNameOfHouse() {
        return nameOfHouse;
    }

    public String getTypeofHouse() {
        return typeofHouse;
    }

    public double getPrice() {
        return price;
    }

    public String getHouseStatus() {
        return houseStatus;
    }

    public void setHouseID(int HouseID) {
        this.HouseID = HouseID;
    }

    public void setNameOfHouse(String nameOfHouse) {
        this.nameOfHouse = nameOfHouse;
    }

    public void setTypeofHouse(String typeofHouse) {
        this.typeofHouse = typeofHouse;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setHouseStatus(String houseStatus) {
        this.houseStatus = houseStatus;
    }

    @Override
    public String toString() {
        return "House{" + "HouseID=" + HouseID + ", nameOfHouse=" + nameOfHouse + ", typeofHouse=" + typeofHouse + ", price=" + price + ", houseStatus=" + houseStatus + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final House other = (House) obj;
        if (this.HouseID != other.HouseID) {
            return false;
        }
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (!Objects.equals(this.nameOfHouse, other.nameOfHouse)) {
            return false;
        }
        if (!Objects.equals(this.typeofHouse, other.typeofHouse)) {
            return false;
        }
        if (!Objects.equals(this.houseStatus, other.houseStatus)) {
            return false;
        }
        return true;
    }
    

}
