package view;

import java.util.Scanner;
import controller.ClubManager;
import java.util.Objects;


public class MenuView {
    public static final ClubManager cm = new ClubManager();
    public static final Scanner sc=new Scanner(System.in);
    
    public static void  newClub(){
        System.out.println("---New Club---");
        System.out.print("Enter full Club name: ");
        String fullname = sc.nextLine();
        System.out.print("Enter short Club name: ");
        String shortname = sc.nextLine();
        System.out.print("Enter a maximum members: ");
        int maxMembers = sc.nextInt();
        cm.newClub(fullname, shortname, maxMembers);
    }
    
    public static void  subscribe(){
        System.out.print("Enter Your id: ");
        long id = sc.nextLong();
        sc.nextLine();
        System.out.print("Enter Your firstname: ");
        String firstname = sc.nextLine();
        System.out.print("Enter Your lastname: ");
        String lastname = sc.nextLine();
        System.out.print("Enter Your department: ");
        String dep = sc.nextLine();
        cm.subscribe(id, firstname, lastname, dep);
    }
    
    public static void  editInfo(){
        System.out.println("---edit info---");
        System.out.print("Enter Your id: ");
        long id = sc.nextLong();
        System.out.print("Enter Your new info [firstname, lastname, department]: ");
        String firstname = sc.next();
        String lastname = sc.next();
        String dep = sc.next();
        cm.editInfo(id,firstname, lastname, dep);
    }
    
    public static void  unsubscribe(){
        System.out.println("---unsubscribe---");
        System.out.print("Enter Your id: ");
        long id = sc.nextLong();
        cm.unsubscribe(id);
    }
    public static void  listMembers(){
        cm.listMembers();
    }
          
    public static void menu() {
       // ClubManager cm = new ClubManager();
        int menuId;
        do {
            System.out.println("<<Main Menu>>");
            System.out.println("1. New Club ");
            System.out.println("2. Membership Subscribe ");
            System.out.println("3. Edit Membership Information");
            System.out.println("4. Membership Unsubscribe ");
            System.out.println("5. List Members ");
            System.out.println("6. Exit ");

            
            System.out.print("Enter your menu [1-6]: ");
            Scanner sc = new Scanner(System.in);
            menuId = sc.nextInt();
            switch (menuId) {
                case 1:
                    newClub();
                    break;
                case 2:
                    subscribe();
                    break;

                case 3:
                    editInfo();
                    break;
                case 4:
                    unsubscribe();
                    break;
                case 5:
                    listMembers();
                    break;
                case 6:
                    System.out.println("Good Bye!");
            }
        } while (menuId != 6);
    }

    public static void main(String[] args) {   
       System.out.println("Hello Git");     
       menu();
    }
}
