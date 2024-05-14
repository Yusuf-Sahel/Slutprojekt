package main;
/*
 * This class is the booking list class... it keeps track of all
 * the seats that are booked and are not booked.
 */
public class BookingList {
    //Denna klass är deklarerad "public", vilket gör att man kan ha tillgång till den utifrån package
    //this is a flag to check is the airplane is booked
    private PassengerInfo[] pi = new PassengerInfo[50];

    public void addPassenger(PassengerInfo pi) {
        for(int i = 0; i < this.pi.length; i++) {
            if(this.pi[i] == null) {
                this.pi[i] = pi;
                break;
            }
            System.out.println("Could not add passenger.");
        }
    }

    public PassengerInfo getPassengerInfo(int i) {
        return pi[i];
    }

    public boolean isBooked() {
        for(int i = 0; i < this.pi.length; i++) {
            if(this.pi[i] == null) {
                return false;
            }
        }
        return true;
    }
}
