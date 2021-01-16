package Seat_Model;

public class Seat {

    private String seatNo;
    private SeatStatus seatStatus;

    public Seat(String seatNo, SeatStatus seatStatus) {
        this.seatNo = seatNo;
        this.seatStatus = seatStatus;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public void setSeatStatus(SeatStatus seatStatus) {
        this.seatStatus = seatStatus;
    }

    public SeatStatus getReservationStatus() {
        return seatStatus;
    }

    public SeatStatus reserve() {
        return this.seatStatus = SeatStatus.NOT_AVAILABLE;
    }

    public SeatStatus unreserve() {
        return this.seatStatus = SeatStatus.AVAILABLE;
    }

}
