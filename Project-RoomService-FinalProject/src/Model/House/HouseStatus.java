/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.House;

/**
 *
 * @author Laptop
 */
public enum HouseStatus {
    AVALIABLE{
          public String toString() {
            return "AVALIABLE";
        }
    },
    BOOKED{
          public String toString() {
            return "BOOKED";
        }
    }
}
