package org.party.festival.booking.controller;

import org.party.festival.booking.domain.Booking;
import org.party.festival.booking.repository.BookingRepository;
import org.springframework.web.bind.annotation.RequestMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@RequestMapping("/bookings")
@Controller
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    protected static final Logger logger = LoggerFactory.getLogger(BookingController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String bookings(String actioned, Model model) {

        logger.info("Received request for admin home, actioned : {}", actioned);

        List<Booking> bookings = null;

        if(actioned == null) {
            actioned = "2";
        }

        if(actioned.equals("1")) {
            bookings = bookingRepository.findAllByActioned( true );
        } else if(actioned.equals("2")) {
            bookings = bookingRepository.findAllByActioned( false );
        } else {
            bookings = bookingRepository.findAll();
        }

        logger.info("Retrieved {} bookings", bookings.size(), actioned);

        model.addAttribute(bookings);
        model.addAttribute("actioned", actioned);

        return "admin/bookings.html";
    }

    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public String view(@PathVariable Long id, Model model) {

        Optional<Booking> booking = bookingRepository.findById(id);

        logger.info("Request view booking {}", booking.get());

        model.addAttribute( booking.get() );

        return "admin/view.html";
    }

    @RequestMapping(value = "/action/{isActioned}/{id}", method = RequestMethod.GET)
    public String view(@PathVariable Boolean isActioned, @PathVariable Long id, Model model) {

        logger.info("Request action booking {} {}", id, isActioned);

        bookingRepository.updateIsActioned(id, isActioned);

        return "redirect:/bookings/";
    }

    @RequestMapping(value = "/charts", method = RequestMethod.GET)
    public String charts(Model model) {

        logger.info("Received request for admin charts");

        return "admin/charts.html";
    }
}
