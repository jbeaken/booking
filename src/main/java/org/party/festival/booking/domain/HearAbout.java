package org.party.festival.booking.domain;

public enum HearAbout {
	BeenBefore("I have been to Festival before"),
	Browsing(" Online browsing"),
	SocialNetwork("Social networking sites (e.g. Facebook, Twitter)"),
	FriendFamily("Heard about it from friend or family"),
	PublicMeeting("Heard about it at a public meeting"),
	Demo("Heard about it at a picket, demo, protest etc."),
	SWPMeeting("Heard about it at a meeting"),
	Leaflet("Was given a leaflet"),
	Poster("Saw a poster"),
	Other("Other");

	String displayName;

	HearAbout(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}
}
