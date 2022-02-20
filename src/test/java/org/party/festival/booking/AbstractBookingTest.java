package org.party.festival.booking;

import org.party.festival.booking.domain.*;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
public abstract class AbstractBookingTest {

    Booking getBooking() {
        return getBooking("firstname", "lastname");
    }

    Booking getBooking(String firstname, String lastname) {
        return getBooking(firstname, lastname, "email@email.com");
    }

    Booking getBooking(String firstname, String lastname, String email) {
        final Booking booking = new Booking();

        booking.setFirstname(firstname);
        booking.setLastname(lastname);
        booking.setEmail(email);
        booking.setTelephone("telephone");
        booking.setHearAbout(HearAbout.BeenBefore);
        booking.setAccommodationNeeds("accomodationNeeds");
        booking.setAccommodationContact("ac");

        Address address = new Address();
        address.setAddress1("address1");
        address.setAddress2("address2");
        address.setPostcode("postcode");

        Ticket ticket = new Ticket();
        ticket.setType(TicketType.FULL);
        ticket.setPricing(TicketPricing.UNWAGED);
        ticket.setWebPrice("3000");
        ticket.setAfterParty(true);

        booking.setAddress(address);
        booking.setTicket(ticket);

        return booking;
    }
}
