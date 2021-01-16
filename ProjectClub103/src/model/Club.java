package model;

import java.util.Scanner;

public class Club {

    private String fullName;
    private String shortName;
    private static int noOfMember;
    private String status;
    public static Student member[];
    public static int count;

    public Club() {
        member = new Student[0];
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public void setNoOfMember(int noOfMember) {
        member = new Student[noOfMember];
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public int getNoOfMember() {
        return noOfMember;
    }

    public static Student[] getMember() {
        return member;
    }
    
   public static boolean removeMember(long id){
        for (int i = 0; i < member.length; i++) {
            if(member[i].getStudentId() == id){
                Student[] newSet = new Student[member.length];
                 for(int index = 0; index < i; index++){
                    newSet[index] = member[index];
                }
                for(int j = i; j < member.length - 1; j++){
                    newSet[j] = member[j+1];  
                    member=newSet;
                    count--;
                }
               return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Club{" + "fullName=" + fullName + ", shortName=" + shortName + ", noOfMember=" + noOfMember + ", status=" + status + '}';
    }
}
