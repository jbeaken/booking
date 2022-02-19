package org.party.festival.booking.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Embeddable
@Data
public class Ticket {
	
	@Enumerated(EnumType.STRING)
	@Column(name="ticket_type", nullable=false)
	@NotNull
	private TicketType type;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ticket_pricing", nullable=false)
	@NotNull
	private TicketPricing pricing;
	
	@Column(name="ticket_web_price")
	@NotNull
	private String webPrice;
	
	private Integer thursday;
	
	private Integer friday;
	
	private Integer saturday;
	
	private Integer sunday;
	
	private Boolean afterParty;
	
	public String getDays() {
		StringBuilder days = new StringBuilder();
		
		if(thursday != null) days.append("T ");
		if(friday != null) days.append("F ");
		if(saturday != null) days.append("Sa ");
		if(sunday != null) days.append("Su");
		
		return days.toString();
	}

	public Integer getNoOfDaysSelected() {
		int noOfDaysSelected = 0;
		if(thursday != null) noOfDaysSelected += thursday;
		if(friday != null) noOfDaysSelected += friday;
		if(saturday != null) noOfDaysSelected += saturday;
		if(sunday != null) noOfDaysSelected += sunday;
		
		return noOfDaysSelected;
	}
}
