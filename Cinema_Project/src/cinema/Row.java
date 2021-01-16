package cinema;

import Seat_Model.Seat;
import Seat_Model.SeatStatus;
import java.util.ArrayList;

public class Row {

    private ArrayList<Seat> seats;
    private static int runningId = 1;
    private int rowClass;
    private int seatCount;
    private int rowId;

    public Row(int rowClass, int seatCount, int rowId) {
        this.rowId = rowId;
        this.rowClass = rowClass;
        this.seatCount = seatCount;
        seats = new ArrayList<Seat>();
        createSeats(this.seatCount);
    }

    public void setRowClass(int rowClass) {
        this.rowClass = rowClass;
    }

    public int getRowClass() {
        return this.rowClass;
    }

    public int getRowNo() {
        return rowId;
    }

    public void createSeats(int seatCount) {
        for (int i = 1; i <= seatCount; i++) {
            seats.add(new Seat("|"+runningId++, SeatStatus.AVAILABLE));
        }
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }
}
