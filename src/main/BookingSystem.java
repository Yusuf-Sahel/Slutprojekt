package main;

import java.util.Scanner;

public class BookingSystem implements BookingSystemInterface {
    //Implementerar gränssnittet "bookingsysteminterface".
    // Denna klass hanterar bokningsystemets  olika funktioner och integration med användare.
    private Destinations destinations;
    private Scanner input;
    //Används för att läsa inmatning från använderen

    //nedan är konstruktorn för bookingsystem-klassen.
    public BookingSystem() {
        this.destinations = new Destinations();
        this.input = new Scanner(System.in);
    }

    public void checkBooking(Scanner input) {
        destinations.checkBooking(input);
    }

    //En metod som används för att boka en plats för en passagerar till en specifik destination

    public void bookSpot(Scanner input, int destination, boolean isFirstClass) {
        destinations.destination(input, destination, isFirstClass);
    }


    public void cancelBooking(Scanner input) {
        destinations.cancelBooking(input);
    }


    public void showAvailableSeats() {
        destinations.showAvailableSeats();
    }


    public boolean isFullyBooked() {
        return destinations.isBooked();
    }


    public void run() {
        System.out.println("Welcome to airplane booking.. please wait for a minute while I initiate");

        while (!isFullyBooked()) {
            System.out.println("What do you want to do?");
            System.out.println("1. Check booking");
            System.out.println("2. Book a spot (Economy)");
            System.out.println("3. Book a spot (First Class)");
            System.out.println("4. Cancel a booking");
            System.out.println("5. Show available seats");
            String sel = input.nextLine();

            if (!isNumber(sel)) {
                System.out.println("Invalid input, please try again. Choose a number between 1-5.");
                continue;
            }

            int seli = Integer.parseInt(sel);

            switch (seli) {
                case 1:
                    checkBooking(input);
                    break;
                case 2:
                    int destination = selectDestination(input);
                    if (destination != -1) {
                        bookSpot(input, destination, false);
                    }
                    break;
                case 3:
                    destination = selectDestination(input);
                    if (destination != -1) {
                        bookSpot(input, destination, true);
                    }
                    break;
                case 4:
                    cancelBooking(input);
                    break;
                case 5:
                    showAvailableSeats();
                    break;
                default:
                    System.out.println("Invalid selection. Please choose a number between 1-5.");
                    break;
            }
        }

        input.close();
        System.out.println("All seats are booked. Thank you for choosing AirLineAirLines to book a flight!");
        System.out.println("Have a good day!");
    }

    private int selectDestination(Scanner input) {
        System.out.println("Where would you like to go?");
        System.out.println("1. America");
        System.out.println("2. Canada");
        System.out.println("3. India");
        System.out.println("4. China");
        System.out.println("5. Japan");
        String sel = input.nextLine();

        if (!isNumber(sel)) {
            System.out.println("Invalid input, please try again. Choose a number between 1-5.");
            return -1;
        }

        int seli = Integer.parseInt(sel);
        if (seli < 1 || seli > 5) {
            System.out.println("Invalid input, please try again. Choose a number between 1-5.");
            return -1;
        }

        return seli - 1;
    }

    //Nedan är en metod som hjälper att kontrollera om en given sträng representerar ett giltig heltal
    //Metoden kommer att returnera "true" om strängen är heltal annars "false".
    public static boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
