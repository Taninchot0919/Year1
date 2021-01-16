package cinema;

import Seat_Model.Seat;
import Seat_Model.SeatStatus;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Show {

    private String showName;
    private LocalDateTime showDate;
    private Theatre theatre;
    private ArrayList<Seat> seats;
    private int freeSeats;
    private String typeOfMovie;

    public Show(String showName, LocalDateTime showDate, Theatre theatre, String typeOfMovie) {
        this.showName = showName;
        this.showDate = showDate;
        this.theatre = theatre;
        this.typeOfMovie = typeOfMovie;
    }

    public void loadSeats() {
        for (Row row : theatre.getRows()) {
            for (Seat seat : row.getSeats()) {
                seats.add(seat);
            }
        }
    }

    public int getFreeSeatsCount() {
        for (Seat seat : seats) {
            if (seat.getReservationStatus() != SeatStatus.NOT_AVAILABLE) {
                freeSeats++;
            }
        }
        return freeSeats;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public void setShowDate(LocalDateTime showDate) {
        this.showDate = showDate;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    public String getShowName() {
        return showName;
    }

    public LocalDateTime getShowDate() {
        return showDate;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }
    public String getTypeShow(){
        return typeOfMovie;
    }
}
