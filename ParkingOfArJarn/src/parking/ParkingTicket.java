
package parking;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;


public class ParkingTicket {
    private static int runningId=1;
    private String ticketId;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private double payedAmount;
    private ParkingTicketStatus parkingTicketStatus;

    public ParkingTicket() {
        
    }
    
    public void issuedAt(){
        this.ticketId = LocalDate.now()+"-"+runningId++;
        this.entryTime = LocalDateTime.of(2020, Month.FEBRUARY, 28, 16, 10);
        parkingTicketStatus=ParkingTicketStatus.ACTIVE;
    }
    
    public void payedAt(){
        this.exitTime=LocalDateTime.now();
        this.payedAmount=calculateParkingHours();
        //System.out.println("Pay Amount:" +this.payedAmount);
        parkingTicketStatus=ParkingTicketStatus.PAID;
        System.out.println(toString());
    }
    
    private long calculateParkingHours(){  
        long hours=ChronoUnit.HOURS.between(entryTime, exitTime);
        System.out.println("hours: "+hours);
        return hours*ParkingLot.PARKING_RATE;
    }

    @Override
    public String toString() {
        return "ParkingTicket{" + "ticketId=" + ticketId + ", entryTime=" + entryTime + ", exitTime=" + exitTime + ", payedAmount=" + payedAmount + ", parkingTicketStatus=" + parkingTicketStatus + '}';
    }
    
    
    
    
    
    
    
}
