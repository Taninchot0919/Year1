package Customer_Model;

import cinema.Person;
import cinema.Ticket;

public class Customer extends Person{
   
    private String location;
    private String phone;
    private Ticket ticket;

    public Customer(String location, String phone, long personId, String firstname, String lastname) {
        super(personId, firstname, lastname);
        this.location = location;
        this.phone = phone;
    }

    public Customer(String location, String phone, Ticket ticket, long personId, String firstname, String lastname) {
        super(personId, firstname, lastname);
        this.location = location;
        this.phone = phone;
        this.ticket = ticket;
    }

    public long getPersonId() {
        return super.getPersonId();
    }

    public String getFirstname() {
        return super.getFirstname();
    }

    public String getLastname() {
        return super.getLastname();
    }

    public String getLocation() {
        return location;
    }

    public String getPhone() {
        return phone;
    }

    public Ticket getTicket() {
        Ticket t = new Ticket();
        this.ticket = t;
        return ticket;
    }


    public void setLocation(String location) {
        this.location = location;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String printCustomer(){
        StringBuilder sb = new StringBuilder();
        sb.append("Name : "+super.getFirstname());
        sb.append("\n");
        sb.append("Lastname : "+super.getLastname());
        sb.append("\n");
        sb.append("Tel. "+phone+ "\tLocation : "+location);
        sb.append("\n");
        sb.append(ticket);
        return sb.toString();
    }
}
