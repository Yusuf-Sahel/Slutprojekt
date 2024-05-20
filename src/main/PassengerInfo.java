package main;

public class PassengerInfo {
    //Skapar massa privata instansvariablar
    //Dessa lagrar alltså information
    private String firstName;
    private String lastName;
    private String dob;
    private boolean isFirstClass;
    private Locations location;

    //Nedan används en metod för att få tillgång till värdet på "Firstname"
    //Då returneras förnamn på passageraren alltså
    public String getFirstName() {
        return firstName;
    }

    //Nedan är en metod som ställer in värdet på "firstname"
    //Den tar emot förnamnet som parameter
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
        //dob (date of birth)
    }

    public boolean isFirstClass() {
        return isFirstClass;
    }

    public void setFirstClass(boolean isFirstClass) {
        this.isFirstClass = isFirstClass;
    }

    public Locations getLocation() {
        return location;
    }

    public void setLocation(Locations location) {
        this.location = location;
    }
}

//Alltså: get & set är en metod som används för att andra klasser ska kunna integrera med "passengerinfo"
//För att hämta eller uppdatera
