package com.phdareys.holdem.model;


public enum CardColor {
	SPADE ("♠️"),
	HEARTS ("♥️"),
	DIAMOND ("♦️"),
	CLUB ("♣️");
	
	String val;
	CardColor(String val) {
		// TODO Auto-generated constructor stub
		this.val=val;
	}
	public String getVal() {
		return val;
	}

}
