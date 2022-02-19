package org.party.festival.booking.domain;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Address {

	private String address1;
	
	private String address2;
	
	private String town;
	
	private String postcode;
	
	private String country;
}
