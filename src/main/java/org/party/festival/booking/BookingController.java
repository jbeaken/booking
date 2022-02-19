package org.party.festival.booking;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    @RequestMapping("/booking")
    public String home() {
        return "hello";
    }
}
