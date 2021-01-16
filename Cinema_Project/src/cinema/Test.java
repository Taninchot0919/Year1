package cinema;

import Customer_Model.Customer;


import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Test {

    public static void main(String[] args) {
        boolean check = false;
        int choice = 0;
        CustomerDatabase custDao = new CustomerDatabaseIMP();
        ArrayList<Show> shows = new ArrayList<Show>();
        ArrayList<Customer> customers = new ArrayList<Customer>();
        ArrayList<Theatre> theatres = new ArrayList<Theatre>();
        ArrayList<Booking> bookings = new ArrayList<Booking>();
        Scanner choose = new Scanner(System.in);

        Theatre t = new Theatre(3, "Ciniplex");
        t.createRows(1, 10, 8);
        theatres.add(t);
        shows.add(new Show("The Conjuring Chapter. II", LocalDateTime.of(2019, Month.APRIL, 26, 15, 30), theatres.get(0), "HORROR"));
        do {
            System.out.println("<<MENU>>");
            System.out.println("1.) Log-in as Manager");
            System.out.println("2.) Display Shows");
            System.out.println("3.) Book Ticket Movie");
            System.out.println("4.) Cancle Booking");
            System.out.println("5.) Exit");
            try {
                System.out.print("Enter choice : ");
                choice = choose.nextInt();
                check = false;
                if (choice < 1 || choice > 5) {
                    System.out.println("Please choose again");
                }
                switch (choice) {
                    case 1:
                        if (t.checkManager() == false) {
                            System.out.println("Failed");
                        } else {
                            Scanner sc = new Scanner(System.in);
                            boolean managerChoice = false;
                            do {
                                System.out.println(" 1.) Add Theatre");
                                System.out.println(" 2.) Add Movie");
                                System.out.println(" 3.) Back");
                                System.out.print("Enter option : ");
                                int number = sc.nextInt();
                                if (number < 1 || number > 3) {
                                    System.out.println("Please choose again");
                                }
                                switch (number) {
                                    case 1:
                                        Scanner alternative = new Scanner(System.in);
                                        Scanner alternative2 = new Scanner(System.in);
                                        Scanner alternative3 = new Scanner(System.in);
                                        System.out.println("ADD THEATRE");
                                        System.out.print("Enter a name for the theatre: ");
                                        String theatreName = alternative.nextLine();
                                        System.out.print("Enter a number for the theatre: ");
                                        int theatreNumber = alternative2.nextInt();
                                        System.out.print("Enter the number of rows: ");
                                        int rowCount = alternative3.nextInt();
                                        Theatre theatre = new Theatre(theatreNumber, theatreName);
                                        theatre.createRows(1, 10, rowCount);
                                        theatres.add(theatre);
                                        theatre.printSeatPlan();
                                        break;
                                    case 2:
                                        Scanner alternative4 = new Scanner(System.in);
                                        Scanner alternative5 = new Scanner(System.in);
                                        Scanner alternative6 = new Scanner(System.in);
                                        System.out.println("ADD SHOW");
                                        System.out.print("Enter the date of the Show [DD/MM/YYYY HH:MM]:");
                                        String userInput = alternative4.nextLine();
                                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                                        LocalDateTime showDate = LocalDateTime.parse(userInput, formatter);
                                        System.out.print("Enter name of Show: \n");
                                        String showName = alternative5.nextLine();
                                        System.out.print("Select a theatre : ");
                                        for (int i = 0; i < theatres.size(); i++) {
                                            System.out.println(i + 1);
                                        }
                                        int theatreNo = alternative6.nextInt();
                                        shows.add(new Show(showName, showDate, theatres.get(theatreNo - 1), "HORROR"));
                                        break;
                                    case 3:
                                        managerChoice = true;
                                        break;

                                }
                            } while (!managerChoice);

                        }
                    case 2:
                        System.out.println("Show all Movie List");
                        for (int i = 0; i < shows.size(); i++) {
                            int showNumber = i + 1;
                            System.out.println("Movie No. : " + showNumber);;
                            System.out.println("Movie Name : " + shows.get(i).getShowName());
                            System.out.println("Movie Date : " + shows.get(i).getShowDate());
                            System.out.println("Type : "+shows.get(i).getTypeShow());
                        }
                        System.out.println("----------------------");
                        break;
                    case 3:
                        Scanner idInput = new Scanner(System.in);
                        System.out.print("Insert your person Id : ");
                        Long registId = idInput.nextLong();
                        Scanner nameInput = new Scanner(System.in);
                        System.out.print("Insert your name : ");
                        String registName = nameInput.nextLine();
                        Scanner surnameInput = new Scanner(System.in);
                        System.out.print("Insert your lastname : ");
                        String regisSurname = surnameInput.nextLine();
                        Scanner phoneInput = new Scanner(System.in);
                        String regisPhone;
                        boolean checkPhone;
                        do {
                            System.out.print("Insert your phone number[xxx-xxxxxxxxxx] : ");
                            String phonePattern = "\\d{3}-\\d{7}";
                            regisPhone = phoneInput.nextLine();
                            checkPhone = regisPhone.matches(phonePattern);
                            if (!checkPhone) {
                                System.out.println("Please inform again as the pattern");
                            }
                        } while (!checkPhone);
                        Scanner locInput = new Scanner(System.in);
                        System.out.print("Insert your location : ");
                        String regisLoc = locInput.nextLine();
                        Customer customer = new Customer(regisLoc, regisPhone, registId, registName, regisSurname);
                        custDao.insert(customer);
                        GenList<Customer> custs = custDao.getAll();
                        System.out.println(custs.toString());
                        customers.add(customer);
            
                        for (int i = 0; i < shows.size(); i++) {
                            int showNumber = i + 1;
                            System.out.println("Show Number: " + showNumber);
                            System.out.println("Show Name:   " + shows.get(i).getShowName());
                            System.out.println("Show Date:   " + shows.get(i).getShowDate());
                        }
                        System.out.print("Enter the show number: ");
                        Scanner showNo = new Scanner(System.in);
                        int showNumber = showNo.nextInt();
                        Scanner rpChoice = new Scanner(System.in);
                        String repeat;
                        System.out.println();
                        do {
                            shows.get(showNumber - 1).getTheatre().printSeatPlan();
                            Scanner inputRow = new Scanner(System.in);
                            System.out.print("Enter the row: ");
                            int selectedRow = inputRow.nextInt();
                            Scanner inputSelectedSeat = new Scanner(System.in);
                            System.out.print("Enter the seat: ");
                            int selectedSeat = inputSelectedSeat.nextInt();
                            System.out.println();
                            Booking booking = new Booking(customer, shows.get(showNumber - 1));
                            if (booking.reserveSeat(selectedRow - 1, selectedSeat - 1)) {
                                bookings.add(booking);
                                System.out.println("The seat is reserved for you.");
                            } else {
                                System.out.println("Sorry this seat is unvailable");
                            }
                            System.out.println();
                            System.out.print("Enter (N) to reserve another seat \n Enter (Y) to check out: ");
                            repeat = rpChoice.nextLine();
                        } while (repeat.equals("N"));
                        System.out.println("-----Receipt-----");
                        int totalCost = 0;
                        for (Booking booking : bookings) {
                            if (booking.getCostumer().getPersonId() == customer.getPersonId()) {
                                totalCost += booking.getCost();
                            }
                        }
                        System.out.println("Costumer ID: " + customer.getPersonId());
                        System.out.println(customer.getTicket());
                        System.out.println("Total costs: " + totalCost + " ฿");
                        System.out.println();
                        break;
                    case 4:
                        long searchId = 0;
                        Scanner cancel = new Scanner(System.in);
                        System.out.print("Search by your person ID : ");
                        searchId = cancel.nextLong();
                        for (Customer customerl : customers) {
                            if (customerl.getPersonId() == searchId) {
                                int removeIndex = customers.indexOf(customerl);
                                for (Booking booking : bookings) {
                                    if (booking.getCostumer().getPersonId() == customerl.getPersonId()) {
                                        if (booking.unreserveSeat()) {
                                            customers.remove(removeIndex);
                                            custDao.delete(customerl);
                                        }
                                    }
                                }

                                System.out.print(customerl.getFirstname() + " " + customerl.getLastname() + " is cancelled his/her reservation\n");
                                   break;
                            } else {
                                System.out.println("Not Found");
                            }
                        }

                        break;
                    case 5:
                        System.out.println("Thank you");
                        System.exit(0);
                        check = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("You have to inform only number");
                choose.next();
                check = true;
                
            }
        } while (!check);
    }
}
