/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ClubCon;
import controller.StudentCon;
import java.util.Scanner;

/**
 *
 * @author taninchot
 */
public class Menu {
    final Scanner sc = new Scanner(System.in);
    final StudentCon stc1 = new StudentCon();
    final ClubCon cc1 = new ClubCon();
    public static void main(String[] args) {
        Menu m1 = new Menu();

        int choice = 0;
        do{
            choice = m1.menu();
            switch(choice){
                case 1:
                    m1.setFullName();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
            
        }while(choice!=6);
    }
    
    public int menu(){
        System.out.println("<<Main Menu>>");
        System.out.println("");
        System.out.println("1. New Club ");
        System.out.println("2. Member Subscribe ");
        System.out.println("3. Edit Membership Infomation ");
        System.out.println("4. Membership Unsubscribe ");
        System.out.println("5. List Member ");
        System.out.println("6. Exit ");
        System.out.println("");
        System.out.print("Enter Your Menu [1-6] : ");
        int selected = sc.nextInt();
        return selected;
    }
    
    public void setFullName(){
        String fullName = sc.nextLine();
        stc1.setStudentName(fullName);
    }
}
