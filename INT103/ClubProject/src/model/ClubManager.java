/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Scanner;
import model.Club;

/**
 *
 * @author Umaporn
 */
public class ClubManager {

    private static final Scanner sc = new Scanner(System.in);
    private Club club;

    public void subscribe() {
        System.out.print("Enter Your id: ");
        long id = sc.nextLong();
        sc.nextLine();
        System.out.print("Enter Your firstname: ");
        String firstname = sc.nextLine();
        System.out.print("Enter Your lastname: ");
        String lastname = sc.nextLine();
        System.out.print("Enter Your department: ");
        String dep = sc.nextLine();
        Student std = new Student(id, firstname, lastname, dep);
        if( club.subscribe(std)){
            System.out.println("Welcome new member!");
        }
        else
            System.out.println("Sorry, cannot adding you to our membership");
        

    }

    public void newClub() {
        System.out.println("---New Club---");
        System.out.print("Enter full Club name: ");
        String fullname = sc.nextLine();
        System.out.print("Enter short Club name: ");
        String shortname = sc.nextLine();
        System.out.print("Enter a maximum members: ");
        int maxMembers = sc.nextInt();

        club = new Club(fullname, shortname, maxMembers);
    }

    public void listMembers() {
        String list= club.toString();
        System.out.println(list);
    }

    public void editInfo() {
        System.out.println("---edit info---");
        System.out.print("Enter Your id: ");
        long id = sc.nextLong();

        System.out.print("Enter Your new info [firstname, lastname, department]: ");
        String firstname = sc.next();
        String lastname = sc.next();
        String dep = sc.next();

        if(club.editInfo(id, firstname, lastname, dep))
            System.out.println("edit completed");
        else
            System.out.println("cannot edit!");
    }

    public void unsubscribe() {
        System.out.println("---unsubscribe---");

        System.out.print("Enter Your id: ");
        long id = sc.nextLong();
        if(club.unsubscribe(id))
            System.out.println("your are unsubscribed");
        
        else
            System.out.println("your are not unsubscribed");
    }

}
