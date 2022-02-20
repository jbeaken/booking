package org.party.festival.booking;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class BookingsTests extends AbstractBookingTest{

    @Autowired
    private MockMvc mvc;

    @Test
    public void testGetAllBookings() throws Exception {

        this.mvc.perform(get("/bookings/")
                .contentType("application/json")
                .accept("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    public void save() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(getBooking());

        this.mvc.perform(post("/bookings/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk());
    }



    @Test
    public void edit() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(getBooking());

        this.mvc.perform(put("/bookings/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteBooking() throws Exception {

        this.mvc.perform(delete("/bookings/1"))
                .andExpect(status().isOk());
    }
}