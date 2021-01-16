package controller;

import java.util.Objects;
import java.util.Scanner;

import model.Club;
import model.Student;

public class ClubManager {

    private static final Scanner sc = new Scanner(System.in);
    private Club club;

    public void subscribe(long id, String firstname, String lastname, String dep) {

        Objects.requireNonNull(firstname, "firstname must be not null");
        Objects.requireNonNull(lastname, "lastname must be not null");
        Objects.requireNonNull(dep, "department must be not null");
        Student std = new Student(id, firstname, lastname, dep);

        if (club.subscribe(std)) {
            System.out.println("Welcome new member!");
        } else {
            System.out.println("Sorry, cannot adding you to our membership");
        }

    }

    public void newClub(String fullname, String shortname, int maxMembers) {
        Objects.requireNonNull(fullname, "fullname must be not null");
        Objects.requireNonNull(shortname, "shortname must be not null");

        this.club = new Club(fullname, shortname, maxMembers);

    }

    public void listMembers() {
        String list = club.toString();
        System.out.println(list);
    }

    public void editInfo(long id, String newFirstname, String newLastname, String newDep) {
        Objects.requireNonNull(newFirstname, "firstname must be not null");
        Objects.requireNonNull(newLastname, "lastname must be not null");
        Objects.requireNonNull(newDep, "department must be not null");
        if (club.editInfo(id, newFirstname, newLastname, newDep)) {
            System.out.println("edit completed");
        } else {
            System.out.println("cannot edit!");
        }
    }

    public void unsubscribe(long id) {

        if (club.unsubscribe(id)) {
            System.out.println("your are unsubscribed");
        } else {
            System.out.println("your are not unsubscribed");
        }
    }

}
