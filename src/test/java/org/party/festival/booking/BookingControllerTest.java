package org.party.festival.booking;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.party.festival.booking.controller.BookingController;
import org.party.festival.booking.domain.Booking;
import org.party.festival.booking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookingController.class)
@TestPropertySource(properties = { "embedded.containers.enabled=false" })
public class BookingControllerTest extends AbstractBookingTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private BookingRepository bookingRepository;

    @Test
    void testGetAllBookings() throws Exception {

        final List<Booking> bookingList = List.of(getBooking(), getBooking("fred", "flintstone"));

        when(bookingRepository.findAll()).thenReturn( bookingList );

        this.mockMvc.perform(get("/bookings/")
                        .contentType("application/json")
                        .accept("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.length()").value(is(2)))
                .andExpect(jsonPath("$.[0].firstname").value(equalTo("firstname")))
                .andExpect(jsonPath("$.[0].lastname").value(equalTo("lastname")))
                .andExpect(jsonPath("$.[0].email").value(equalTo("email@email.com")))
                .andExpect(jsonPath("$.[0].telephone").value(equalTo("telephone")))
                .andExpect(jsonPath("$.[1].firstname").value(equalTo("fred")))
                .andExpect(jsonPath("$.[1].lastname").value(equalTo("flintstone")));

        Mockito.verify(bookingRepository).findAll();
    }

    @Test
    void testSaveBooking() throws Exception {

        final Booking booking = getBooking();

        String bookingJson = new ObjectMapper().writeValueAsString(booking);

        when(bookingRepository.save(booking)).thenReturn( booking );

        this.mockMvc.perform(post("/bookings/")
                        .contentType("application/json")
                        .content(bookingJson)
                        .accept("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.firstname").value(equalTo("firstname")))
                .andExpect(jsonPath("$.lastname").value(equalTo("lastname")))
                .andExpect(jsonPath("$.email").value(equalTo("email@email.com")))
                .andExpect(jsonPath("$.telephone").value(equalTo("telephone")));

        Mockito.verify(bookingRepository).save( booking );
    }
}
