import javax.swing.JOptionPane;
import model.Club;
import model.Student;
import java.util.Scanner;
import static model.Club.member;

public class app {

//    private static int index;
//    private static long studentId;
    private static int count;
    Club c1 = new Club();

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        app a1 = new app();
        int choice = 0;
        do {
            choice = menu();
            switch (choice) {
                case 1:
                    a1.createClub();
                    break;
                case 2:
                    a1.memberSub();
                    break;
                case 3:
                    a1.editMemberInfo();
                    break;
                case 4:
                    a1.memberUnsub();
                    break;
                case 5:
                    a1.listMember();
                    break;

            }
        } while (choice != 6);
    }

    private static int menu() {
        System.out.println("<<Main Menu>>");
        System.out.println("1. New Club");
        System.out.println("2. Membership Subscribe");
        System.out.println("3. Edit Membership Infomation");
        System.out.println("4. Membership Unsubscribe");
        System.out.println("5. List Members");
        System.out.println("6. Exit");
//        System.out.print("Enter Your Menu[1-6]: ");
        String strScore = JOptionPane.showInputDialog(null, "Enter Your Menu[1-6]: ");
        int selected;
        selected = Integer.parseInt(strScore);
//        sc.nextLine();
        return selected;
    }

    private static void createClub() {
        Club c1 = new Club();
        System.out.print("Please Enter Full Name of Club : ");
        String fullName = sc.nextLine();
        c1.setFullName(fullName);
        System.out.print("Please Enter Short Name of Club : ");
        String shortName = sc.nextLine();
        c1.setShortName(shortName);
        System.out.print("Please Enter Number of Member : ");
        int noOfMember = sc.nextInt();
        c1.setNoOfMember(noOfMember);
        System.out.println("Your club is " + c1.getFullName());
        System.out.println("Short name is " + c1.getShortName());
        System.out.println("Your club has member for " + c1.member.length + " Member");

    }

    private static boolean memberSub() {
        if (isFull()) {
            System.out.println("This Club was Close");

            return false;
        }
        Scanner id = new Scanner(System.in);
        System.out.print("Enter Your ID: ");
        long studentId = id.nextLong();

        if (checkAlreadyId(studentId)) {
            System.out.println("This member already subscribe");

            return false;
        }
        if (studentId == 0) {
            System.out.println("Student ID can't 0");

        } else {
            Scanner s1 = new Scanner(System.in);
            System.out.print("Enter Your First Name : ");
            String name = s1.nextLine();
            System.out.print("Enter Your Last Name : ");
            String lastName = s1.nextLine();
            System.out.print("Enter Your Faculty : ");
            String faculty = s1.nextLine();
            member[count++] = new Student(studentId, name, lastName, faculty);
            System.out.println("Add successfully");

        }
        return true;
    }

    private static boolean editMemberInfo() {
        Scanner scString = new Scanner(System.in);
        Scanner id = new Scanner(System.in);
        System.out.print("Enter Your ID: ");
        long studentId = id.nextLong();
        if (checkAlreadyId(studentId)) {
            if (studentId == 0) {
                System.out.println("Student ID can't 0 ");

                return false;
            }
            System.out.print("Edit First name : ");
            String fullName = scString.nextLine();
            System.out.print("Edit Last name : ");
            String lName = scString.nextLine();
            System.out.print("Edit Faculty : ");
            String fac = scString.nextLine();
            for (int i = 0; i < member.length; i++) {
                if (studentId == (member[i].getStudentId())) {
                    member[i].setName(fullName);
                    member[i].setLastname(lName);
                    member[i].setFaculty(fac);
                    System.out.println("Edit sucessfully");

                    return true;
                }
            }
        }
        System.out.println("This ID is not a member ");

        return false;
    }

    private void memberUnsub() {

        Scanner mus = new Scanner(System.in);
        System.out.print("Enter Your ID: ");
        long studentId = mus.nextLong();
        for (Student student : member) {
            if (student != null) {
                if (studentId != student.getStudentId()) {
                    System.out.println("This number doesn't exists in the system");
//                    continue;
                } 
            }
        }
        
        boolean state = c1.removeMember(studentId);
        if (state) {
            count--;
            System.out.println("Remove Success!!");
        } else {
            System.out.println("Can't Remove ");
        }

    }

    private static void listMember() {
        if (count <= 0) {
            System.out.println("This club have no member");

        }
        for (int i = 0; i < count; i++) {
            System.out.println(model.Club.member[i]);
        }
        int seatAvailable = member.length - count;
        if (seatAvailable >= 1) {
            System.out.println("This club was available for " + seatAvailable + " Member");
        }

    }

    //ไว้เช็ค
    private static boolean isFull() {
        return count == member.length;
    }

    //ไว้เช็ค
    public static boolean checkAlreadyId(long id) {
        for (int i = 0; i < count; i++) {
            if (id == member[i].getStudentId()) {
                return true;
            }
        }
        return false;
    }
}
