/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.BookedHouse;

import java.util.ArrayList;

/**
 *
 * @author Laptop
 */
public interface BookedHouseDao {
     public int createBookedHouse(BookedHouse bookHouse);

    public BookedHouse getBookedHouseById(int bookHouseID);

    public ArrayList<BookedHouse> getAllBookedHouse();

    public int updateBookedHouse(BookedHouse bookHouseID);

    public int deleteBookedHouse(int bookHouseID);
}
