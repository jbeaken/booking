package org.party.festival.booking.exception;


public class BookingNotFoundException extends RuntimeException {

    public BookingNotFoundException(String message) {

        super("Could not find booking " + message);
    }
}
