package main;

import java.util.Scanner;

public interface BookingSystemInterface {
    void checkBooking(Scanner input);
    void bookSpot(Scanner input, int destination, boolean isFirstClass);
    void cancelBooking(Scanner input);
    void showAvailableSeats();
    boolean isFullyBooked();
    void run();
}
