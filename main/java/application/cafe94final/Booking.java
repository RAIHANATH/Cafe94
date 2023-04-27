package application.cafe94final;

import java.security.InvalidParameterException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

/**
 * This class represents booking with number of guests, a customer ID, date of the booking,
 * and time of the booking.
 *
 * @author Raihanath
 * version 0.5
 */
public class Booking {
    private int numberOfGuests;
    private int customerId;
    private LocalDateTime bookingTime;
    private Date bookingDate;
    private static int bookItemCounter = 0;
    private static ArrayList<Booking> bookingArray = new ArrayList<>();

    /**
     * Create a booking with number of guests, customer ID, booking time and date.
     *
     * @param numberOfGuests The number of guests,
     * @param customerId     The customer's ID,
     * @param bookingTime    This shows the booked time,
     * @param bookingDate    This shows the booked date.
     */
    public Booking(int numberOfGuests, int customerId, LocalDateTime bookingTime, Date bookingDate) {
        this.numberOfGuests = numberOfGuests;
        this.customerId = customerId;
        this.bookingTime = bookingTime;
        this.bookingDate = bookingDate;
        bookItemCounter++;
    }

    /**
     * Get all details
     *
     * @param bookName specifies the menu for booking
     * @return list of booked details in an array
     * @throws InvalidParameterException
     */
    public static ArrayList<Booking> getBooking(String bookName)
            throws InvalidParameterException {
        switch (bookName) {
            case ("BookingArray"):
                return bookingArray;
            default:
                throw new InvalidParameterException("bad");

        }


    }

    /**
     * Returns a formatted string representing booking details:time and date.
     *
     * @return the booking time and date
     */
    public String toString() {
        return "value" + this.bookingTime + " " + this.bookingDate;
    }

    /**
     * Adds a booked data
     *
     * @param whichMenu the booked details to add to.
     */
    public void addToMenu(String whichMenu) {
        getBooking(whichMenu).add(this);
    }

    /**
     * Removes a booked data from the booked array.
     *
     * @param whichMenu, the booked data to remove from.
     */
    public void removeFromBooking(String whichMenu) {
        getBooking(whichMenu).remove(this);

    }
}



