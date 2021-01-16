/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Person;

/**
 *
 * @author Laptop
 */
public enum Rank {
    STAFF{
        public String toString(){
            return "STAFF";
        }
    },
    MANAGER{
        public String toString(){
            return "MANAGER";
        }
    };
}
