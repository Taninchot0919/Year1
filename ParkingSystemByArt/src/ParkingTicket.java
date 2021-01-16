
import java.time.LocalDateTime;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author taninchot
 */
public class ParkingTicket {
    private static int runningId;
    private String ticketId;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private double payedAmount;
    private ParkingTicketStatus parkingTicketStatus;
    
    public ParkingTicket(){
        
    }
    public void issueAt(){
        entryTime = LocalDateTime.now();
        parkingTicketStatus = parkingTicketStatus.ACTIVE;
    }
    public void payedAt(){
        entryTime = LocalDateTime.now();
        parkingTicketStatus = parkingTicketStatus.PAID;
    }
    public long calculateParkingHours(){
        
        return 0;
    }

    @Override
    public String toString() {
        return "ParkingTicket{" + "ticketId=" + ticketId + ", entryTime=" + entryTime + ", exitTime=" + exitTime + ", payedAmount=" + payedAmount + ", parkingTicketStatus=" + parkingTicketStatus + '}';
    }
    
}
