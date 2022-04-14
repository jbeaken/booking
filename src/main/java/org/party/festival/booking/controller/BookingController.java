package org.party.festival.booking.controller;

import lombok.extern.slf4j.Slf4j;
import org.party.festival.booking.domain.Booking;
import org.party.festival.booking.exception.BookingNotFoundException;
import org.party.festival.booking.repository.BookingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/bookings")
@RestController
@Slf4j
public class BookingController {

    private final BookingRepository bookingRepository;

    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }


    @GetMapping(value = "/", consumes = "application/json", produces = "application/json")
    public List<Booking> findAllBookings() {
        return bookingRepository.findAll();
    }

    @GetMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public Booking booking(@PathVariable("id") Long id) {
        return bookingRepository.findById(id).orElseThrow(() -> new BookingNotFoundException("Cannot find booking " + id));
    }

    @PostMapping(value = "/")
    public Booking save(@RequestBody Booking booking) {
        return bookingRepository.save(booking);
    }

    @PutMapping(value = "/{id}")
    public Booking edit(@RequestBody Booking booking, @PathVariable Long id) {

        return bookingRepository.findById(id)
                .map(b -> {
//                    b.setName(booking.getName());
//                    b.setRole(booking.getRole());
                    return bookingRepository.save(b);
                })
                .orElseGet(() -> {
                    booking.setId(id);
                    return bookingRepository.save(booking);
                });
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        bookingRepository.deleteById( id );
    }
}
