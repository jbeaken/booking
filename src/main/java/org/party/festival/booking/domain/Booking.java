package org.party.festival.booking.domain;

import lombok.Data;

import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Booking extends JpaEntity {

    @NotNull
    @Enumerated(EnumType.STRING)
    private BookingStatus status = BookingStatus.UNCONFIRMED;

    @Embedded
    @NotNull
    private Ticket ticket;

    @NotNull
    //private LocalDateTime date = LocalDateTime.now();
    private Date date = new Date();

    @NotNull
    private Boolean isActioned = false;

    private String discountCode;

    @Embedded
    @NotNull
    private Address address;

    @NotNull
    @NotBlank
    private String firstname;

    @NotNull
    @NotBlank
    private String lastname;

    private String college;

    private String tradeUnion;

    @Email
    @NotNull
    private String email;

    private String telephone;

    private String otherMembership;

    @Enumerated(EnumType.STRING)
    private HearAbout hearAbout;

    private String accommodationNeeds;

    private String accommodationContact;

    private Integer childrenUnder18Months;

    private Integer children18MonthsTo5Years;

    private Integer children5YearsTo11years;

    public Boolean getRequiresCreche() {
        if((childrenUnder18Months != null && childrenUnder18Months > 0)
                || (children18MonthsTo5Years != null && children18MonthsTo5Years > 0)
                || (children5YearsTo11years != null && children5YearsTo11years > 0)) return true;
        return false;
    }

    public String getFullname() {

        return firstname + " " + lastname;
    }
}
