package main;

import java.util.Scanner;

public class Destinations {
    private BookingList[] bookingLists;
    //En array som representerar bokninglistorna för olika destinationer

    public Destinations() {
        this.bookingLists = new BookingList[5];
        for (int i = 0; i < bookingLists.length; i++) {
            bookingLists[i] = new BookingList();
        }
    }

    //Nedan är en metod för att kunna boka en sittplats till en viss destination.
    //Den tar emot användarinmatning genom "scanner"
    //Den tar emot "destination" för att ange destination och
    //"isfirstclass" för att ange om det ekonomi eller first-class
    public void destination(Scanner input, int destination, boolean isFirstClass) {
        if (bookingLists[destination].isBooked(isFirstClass)) {
            System.out.println("Unfortunately, there is no room on this plane.");
            System.out.println("Please restart and choose a new place to go.");
        } else {
            PassengerInfo pi = new PassengerInfo();
            System.out.println("What is your first name?");
            pi.setFirstName(input.nextLine());
            System.out.println("What is your last name?");
            pi.setLastName(input.nextLine());
            System.out.println("What is your Date Of Birth? (ddmmyyyy)");
            pi.setDob(input.nextLine());
            pi.setFirstClass(isFirstClass);
            Locations[] locations = Locations.values();
            pi.setLocation(locations[destination]);
            bookingLists[destination].addPassenger(pi);
            System.out.println("Thank you! We got you added! Thank you for choosing AirLineAirLines");
        }
    }

    //En metod för att kontrollera en bokning.
    //metoden ber om en del information för att kunna gå genom bokningslistan och see om personen bokad en resa
    public void checkBooking(Scanner input) {
        System.out.println("Where are you going?");
        System.out.println("1. America");
        System.out.println("2. Canada");
        System.out.println("3. India");
        System.out.println("4. China");
        System.out.println("5. Japan");
        String sel = input.nextLine();

        if (!BookingSystem.isNumber(sel)) {
            System.out.println("Invalid input, please try again. Choose a number between 1-5.");
            return;
        }

        int seli = Integer.parseInt(sel) - 1;
        System.out.println("What is your first name?");
        String firstName = input.nextLine();
        System.out.println("What is your last name?");
        String lastName = input.nextLine();
        System.out.println("What is your Date Of Birth? (ddmmyyyy)");
        String dob = input.nextLine();

        for (PassengerInfo pi : bookingLists[seli].getPassengers()) {
            if (pi != null && pi.getFirstName().equals(firstName) && pi.getLastName().equals(lastName) && pi.getDob().equals(dob)) {
                System.out.println("Booking found for " + pi.getFirstName() + " " + pi.getLastName() + " to " + pi.getLocation());
                return;
            }
        }

        System.out.println("No booking found for the provided details.");
    }

    public void cancelBooking(Scanner input) {
        System.out.println("Where are you going?");
        System.out.println("1. America");
        System.out.println("2. Canada");
        System.out.println("3. India");
        System.out.println("4. China");
        System.out.println("5. Japan");
        String sel = input.nextLine();

        if (!BookingSystem.isNumber(sel)) {
            System.out.println("Invalid input, please try again. Choose a number between 1-5.");
            return;
        }

        int seli = Integer.parseInt(sel) - 1;
        System.out.println("What is your first name?");
        String firstName = input.nextLine();
        System.out.println("What is your last name?");
        String lastName = input.nextLine();
        System.out.println("What is your Date Of Birth? (ddmmyyyy)");
        String dob = input.nextLine();

        if (bookingLists[seli].removePassenger(firstName, lastName, dob)) {
            System.out.println("Booking successfully canceled.");
        } else {
            System.out.println("No booking found for the provided details.");
        }
    }

    public void showAvailableSeats() {
        for (int i = 0; i < bookingLists.length; i++) {
            Locations location = Locations.values()[i];
            int economySeats = bookingLists[i].availableSeats(false);
            int firstClassSeats = bookingLists[i].availableSeats(true);
            System.out.println(location + " - Economy seats available: " + economySeats + ", First Class seats available: " + firstClassSeats);
        }
    }

    //En metod för att kontrollera om alla platser är bokade för alla destinationer
    public boolean isBooked() {
        for (BookingList bl : bookingLists) {
            if (!bl.isBooked()) {
                return false;
            }
        }
        return true;
    }
}
