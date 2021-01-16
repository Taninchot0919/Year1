package model;

import java.util.Scanner;

public class Club {
    private String fullClubName;
    private String shorClubName;
    private int Clubmember;
    
    Club c1 = new Club();
    final Scanner sc = new Scanner(System.in);

    public String getFullClubName() {
        return fullClubName;
    }

    public void setFullClubName(String fullClubName) {
        this.fullClubName = fullClubName;
    }

    public String getShorClubtName() {
        return shorClubName;
    }

    public void setShorClubtName(String shorClubtName) {
        this.shorClubName = shorClubtName;
    }

    public int getClubmember() {
        return Clubmember;
    }

    public void setClubmember(int Clubmember) {
        this.Clubmember = Clubmember;
    }


    
    public void newClub(){
        System.out.println("Enter Full Club Name : ");
        String fullClubName = sc.nextLine();
        c1.setFullClubName(fullClubName);
        System.out.println("Enter Short Club Name : ");
        String shortClubName = sc.nextLine();
        c1.setShorClubtName(shortClubName);
        System.out.println("Enter Your Maximum Member : ");
        int member = sc.nextInt();
        c1.setClubmember(member);
    }
    
}
