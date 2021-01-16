package cinema;

import Seat_Model.Seat;
import Seat_Model.SeatStatus;
import Manager_Model.Manager;
import java.util.ArrayList;
import java.util.Scanner;

public class Theatre {
    private String name;
    private int theatreNumber;
    private int rowCount;
    private ArrayList<Row> rows;
    private static int runningId = 1;
    private Manager m = new Manager("Manager", 123456, 25952, "Amane", "Tsukasa");

    public Theatre(int theatreNumber, String name) {
        this.name = name;
        this.theatreNumber = theatreNumber;
        rows = new ArrayList<Row>();
    }

    public void createRows(int rowClass, int seatCount, int rowCount) {
        for (int i = 1; i <= rowCount; i++) {
            rows.add(new Row(rowClass, seatCount, runningId++));
        }
        this.rowCount += rowCount;
    }

    public ArrayList<Row> getRows() {
        return rows;
    }

    public void printSeatPlan() {
        System.out.println();
        int maxSeatsInRow = 0;
        for (Row row : getRows()) {
            if (row.getSeats().size() > maxSeatsInRow) {
                maxSeatsInRow = row.getSeats().size();
            }
        }
        System.out.print("   |");
        for (int i = 1; i <= maxSeatsInRow; i++) {
            System.out.print("  " + i+"  ");
        }
        System.out.print("\n");
        System.out.print("----");
        for (int i = 1; i <= maxSeatsInRow; i++) {
            if (i > 9) {
                System.out.print("------");
            } else {
                System.out.print("-----");
            }
        }
        System.out.print("\n");
        for (Row row : getRows()) {
            if (row.getRowNo() > 9) {
                System.out.print(row.getRowNo() + " | ");
            } else {
                System.out.print(row.getRowNo() + "  | ");
            }
            for (Seat seat : row.getSeats()) {

                if (seat.getReservationStatus() == SeatStatus.NOT_AVAILABLE) {
                    System.out.print(" X ");
                } else {
                    System.out.print(seat.getSeatNo() + " ");
                }
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public String getName() {
        return name;
    }
    
    public boolean checkManager() {
        Scanner tryUsername = new Scanner(System.in);
        Scanner tryPass = new Scanner(System.in);
        System.out.println("Log-in as Manager");
        System.out.println("*************************");
        System.out.print("\tUsername : ");
        String usernameInput = tryUsername.nextLine();
        System.out.print("\tPassword : ");
        long passInput = tryPass.nextLong();
        if (m.getUsername().equals(usernameInput) || m.getPassword() == passInput) {
            System.out.println("Login success");
            return true;
        } else {
            return false;
        }
    }
}
