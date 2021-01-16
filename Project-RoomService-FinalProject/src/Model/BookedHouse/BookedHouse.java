/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.BookedHouse;

import java.sql.Timestamp;


/**
 *
 * @author Laptop
 */
public class BookedHouse {
    private int BookedHouseID;
    private int customerID;
    private int houseID;
    private Timestamp checkIndate;
    private Timestamp checkOutdate;

    public BookedHouse() {
    }

    public BookedHouse(int customerID, int houseID, Timestamp checkIndate, Timestamp checkOutdate) {
        this.customerID = customerID;
        this.houseID = houseID;
        this.checkIndate = checkIndate;
        this.checkOutdate = checkOutdate;
    }

    
    public int getBookedHouseID() {
        return BookedHouseID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getHouseID() {
        return houseID;
    }

    public Timestamp getCheckIndate() {
        return checkIndate;
    }

    public Timestamp getCheckOutdate() {
        return checkOutdate;
    }

   

    public void setBookedHouseID(int BookedHouseID) {
        this.BookedHouseID = BookedHouseID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setHouseID(int houseID) {
        this.houseID = houseID;
    }

    public void setCheckIndate(Timestamp checkIndate) {
        this.checkIndate = checkIndate;
    }

    public void setCheckOutdate(Timestamp checkOutdate) {
        this.checkOutdate = checkOutdate;
    }

    @Override
    public String toString() {
        return "BookedHouse{" + "BookedHouseID=" + BookedHouseID + ", customerID=" + customerID + ", houseID=" + houseID + ", checkIndate=" + checkIndate + ", checkOutdate=" + checkOutdate + '}';
    }


   
    
    
    
    
}
