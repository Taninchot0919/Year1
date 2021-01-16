/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Service;

import Model.BookedHouse.BookedHouse;
import Model.BookedHouse.BookedHouseDaoImpl;
import java.util.ArrayList;

/**
 *
 * @author Laptop
 */
public class BookedHouseService {

    private final BookedHouseDaoImpl bookedHouseDaoImpl = new BookedHouseDaoImpl();

    public int createBookedHouse(BookedHouse bookHouse) {
        return bookedHouseDaoImpl.createBookedHouse(bookHouse);
    }

    public BookedHouse getBookedHouseById(int bookHouseID) {
        return bookedHouseDaoImpl.getBookedHouseById(bookHouseID);
    }

    public ArrayList<BookedHouse> getAllBookedHouse() {
        return bookedHouseDaoImpl.getAllBookedHouse();
    }

    public int updateBookedHouse(BookedHouse bookHouse) {
        return bookedHouseDaoImpl.updateBookedHouse(bookHouse);
    }

    public int deleteBookedHouse(int bookHouseID) {
        return bookedHouseDaoImpl.deleteBookedHouse(bookHouseID);
    }
}
