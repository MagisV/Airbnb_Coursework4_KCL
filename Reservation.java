 

import java.time.LocalDate;


/**
 * A blueprint for reservations created by the user. Reservations are created from the database, but are also created
 * when the database is not used.
 *
 * @author  Valentin Magis, Rahin Ashraf, Vandad Vafai Tabrizi, Barnabas Szalai
 * @version 1.0
 * @since   2021-03-11
 */
public class Reservation {

    private final int reservationID;
    private final LocalDate arrival;
    private final LocalDate departure;
    private final int bookerID;
    private final int numberOfGuests;
    private double price;
    private final String listingID;

    /**
     * A constructor which is used to initialize the instance variables of the class
     */
    Reservation(int reservationID, LocalDate arrival, LocalDate departure, int bookerID,
                int numberOfGuests, double price, String listingID) {
        this.reservationID = reservationID;
        this.arrival = arrival;
        this.departure = departure;
        this.bookerID = bookerID;
        this.numberOfGuests = numberOfGuests;
        this.price = price;
        this.listingID = listingID;
    }

    public int getReservationID() {
        return reservationID;
    }

    public LocalDate getArrival() {
        return arrival;
    }

    public LocalDate getDeparture() {
        return departure;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getListingID() {
        return listingID;
    }

}
