package org.party.festival.booking;

import org.junit.jupiter.api.Test;
import org.party.festival.booking.domain.Booking;
import org.party.festival.booking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.List;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookingRepositoryTest extends AbstractBookingTest {

    @Autowired private DataSource dataSource;
    @Autowired private JdbcTemplate jdbcTemplate;
    @Autowired private EntityManager entityManager;
    @Autowired private BookingRepository bookingRepository;

    @Test
    void injectedComponentsAreNotNull() {
        assert dataSource != null;
        assert jdbcTemplate != null;
        assert entityManager != null;
        assert bookingRepository != null;
    }

    @Test
    void getAllBookings() {
        final List<Booking> bookingList = bookingRepository.findAll();

        assert bookingList.size() == 0;
    }

    @Test
    void saveBooking() {
        final Booking booking = getBooking();

        Booking savedBooking = bookingRepository.save(booking);

        assert savedBooking.getId() == 1l;
        assert savedBooking.getFirstname() == "firstname";
        assert savedBooking.getLastname() == "lastname";
    }
}
