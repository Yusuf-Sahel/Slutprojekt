package main;

import java.util.Scanner;

/*
 * This keeps track of all the destinations information
 */

public class Destinations {

    // to keep track if all airlines are booked
    private boolean isBooked = false;

    private BookingList[] bl = new BookingList[5];

    public Destinations() {
        for (int i = 0; i < bl.length; i++) {
            bl[i] = new BookingList();
        }
    }

    /*
     * booking list positions America [0] Canada [1] India [2] China [3] Japan [4]
     */
    public void destination(Scanner input, int destination) {
        System.out.println("Great choice!! Many wonders to see there!");
        System.out.println("Lets check for any spaces on the airplane...");
        if (bl[destination].isBooked()) {
            System.out.println("Unfortunityly there is no room on the this plane.");
            System.out.println("But there are many other places to go!");
            System.out.println("Please restart and choose a new place to go");
        } else {
            System.out.println("Looks like there is room. lets get you booked.");
            System.out.println("I got a few questions to ask you");
            PassengerInfo pi = new PassengerInfo();
            System.out.println("what is your first name?");
            pi.setFirstName(input.nextLine());
            System.out.println("What is your last name?");
            pi.setLastName(input.nextLine());
            System.out.println("What is your Date Of Birth? (ddmmyyyy)");
            pi.setDob(input.nextLine());
            Locations[] locatal = Locations.values();
            pi.setLocation(locatal[destination]);
            bl[destination].addPassenger(pi);
            System.out.println("Thank you! We got you added! Thank you for choosing AirLinesAirLines");
        }
    }

    public void checkBooking(Scanner input) {
        boolean restart = true;
        while (restart) {

            System.out.println("Alright im gonna ask you some questions");
            System.out.println("Where are you going?");
            System.out.println("1. America");
            System.out.println("2. Canada");
            System.out.println("3. India");
            System.out.println("4. China");
            System.out.println("5. Japan");
            System.out.println("1. America");
            String sel = input.nextLine();
            if (!isNumber(sel)) {
                System.out.println("Invalid input please try again. Choose number between 1-5");
                continue;
            }
            int seli = Integer.parseInt(sel);
            Locations[] locatal = Locations.values();
            PassengerInfo pi = new PassengerInfo();
            pi.setLocation(locatal[seli]);

            System.out.println("what is your first name?");
            pi.setFirstName(input.nextLine());
            System.out.println("What is your last name?");
            pi.setLastName(input.nextLine());
            System.out.println("What is your Date Of Birth? (ddmmyyyy)");
            pi.setDob(input.nextLine());

            for (int i = 0; i < 50; i++) {
                PassengerInfo tmppi = bl[seli].getPassengerInfo(i);
                if (tmppi.getFirstName().equals(pi.getFirstName()) && tmppi.getLastName().equals(pi.getLastName())
                        && tmppi.getDob().equals(pi.getDob()) && tmppi.getLocation() == locatal[seli]) {
                    System.out.println("We got your booking place. you are good to go");
                    break;
                }
            }
        }
    }

    public static boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true; // If successful, it's a number
        } catch (NumberFormatException e) {
            return false; // If it throws NumberFormatException, it's not a number
        }
    }

    public boolean isBooked() {
        return isBooked;
    }

}
