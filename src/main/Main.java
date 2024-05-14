package main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to airplane booking.. please wait for a minute while I initiate");
        Destinations destinations = new Destinations();
        Scanner input = new Scanner(System.in);

        while (destinations.isBooked() == false) {
            System.out.println("What do you want to do?");
            System.out.println("1. Check booking");
            System.out.println("2. Book a spot");
            System.out.println("pro tip, use your number keys on your keyboard to choose a selection");
            String sel = input.nextLine();

            if (!isNumber(sel)) {
                System.out.println("Invalid input please try again. Choose number between 1-5");
                continue;
            }


            int seli = Integer.parseInt(sel);

            if(seli == 1) {
                destinations.checkBooking(input);
            }

            System.out.println("Where would you like to go?");
            System.out.println("1. America");
            System.out.println("2. Canada");
            System.out.println("3. India");
            System.out.println("4. China");
            System.out.println("5. Japan");
            sel = input.nextLine();
            if (!isNumber(sel)) {
                System.out.println("Invalid input please try again. Choose number between 1-5");
                continue;
            }

            seli = Integer.parseInt(sel);

            System.out.println("You want to go to America! Great choice.");
            System.out.println("Let me check for availble seats");
            destinations.destination(input, seli);// passing scanner to save memory in some way

        }
        input.close();
        System.out.println("All seats are booked. Thank you for choose AirLineAirLines to book a flight!");
        System.out.println("Have a good day");
    }

    public static boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true; // If successful, it's a number
        } catch (NumberFormatException e) {
            return false; // If it throws NumberFormatException, it's not a number
        }
    }

}