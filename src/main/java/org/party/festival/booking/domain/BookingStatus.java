package org.party.festival.booking.domain;

public enum BookingStatus {
	UNCONFIRMED("Unconfirmed"),           
	CANCELLED("Cancelled"),
	PAYMENT_FAILED("Payment Failed"),
	PAID("Paid");
	
	String displayName;
	
	BookingStatus(String displayName) {
		this.displayName = displayName;
	}
	
	public String getDisplayName() {
		return displayName;
	}
}
