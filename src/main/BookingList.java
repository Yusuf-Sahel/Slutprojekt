package main;

import java.util.ArrayList;
import java.util.List;

public class BookingList {
    private List<PassengerInfo> passengers;
    //Representerar passagerarlistan för bokningen
    private static final int ECONOMY_CAPACITY = 40;
    //Deklarera konstanter, vilket anger antal ekonomi-sittplatser
    private static final int FIRST_CLASS_CAPACITY = 10;
    //Deklarera konstanter, vilket anger antal first-class sittplatser
    public BookingList() {
        this.passengers = new ArrayList<>();
        //Konstruktorn för bookinglist
    }

    public void addPassenger(PassengerInfo pi) {
        passengers.add(pi);
        //En metod som används för att lägga till en passagerare i bookningslistan.
    }

    //Nedan är en metod som används för att ta bort passagerare från bookinglist ("Cancel booking" knappen)
    //Passageraren tas bort baserat på förnamn, efternamn, dob osv.
    //Om passagerarens bokning hittas och tas bort så returneras det "true". Annars "false"
    public boolean removePassenger(String firstName, String lastName, String dob) {
        for (PassengerInfo pi : passengers) {
            if (pi.getFirstName().equals(firstName) && pi.getLastName().equals(lastName) && pi.getDob().equals(dob)) {
                passengers.remove(pi);
                return true;
            }
        }
        return false;
    }

    //En metod för att hämta hela bokningslistan av passagerare
    public List<PassengerInfo> getPassengers() {
        return passengers;
    }

    //Nedan används en metod för att kontrollera ekonomi eller first-class är fullbokade.
    //Det används boolean parameter för att ange vilke klass som ska kontrolleras
    //btw pi = passengerinfo
    public boolean isBooked(boolean isFirstClass) {
        int count = 0;
        for (PassengerInfo pi : passengers) {
            if (pi.isFirstClass() == isFirstClass) {
                count++;
            }
        }
        if (isFirstClass) {
            return count >= FIRST_CLASS_CAPACITY;
        } else {
            return count >= ECONOMY_CAPACITY;
        }
    }

    //Metod för att kontrollera om både ekonomi & first-class är fullbokad.
    public boolean isBooked() {
        return isBooked(true) && isBooked(false);
    }

    //En metod som anger antal lediga platser
    public int availableSeats(boolean isFirstClass) {
        int count = 0;
        for (PassengerInfo pi : passengers) {
            if (pi.isFirstClass() == isFirstClass) {
                count++;
            }
        }
        if (isFirstClass) {
            return FIRST_CLASS_CAPACITY - count;
        } else {
            return ECONOMY_CAPACITY - count;
        }
    }
}
