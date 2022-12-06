package com.abctravels.planjourney;

public class Planjourney  {

	private String source;
	private String destianation;
	private int passengers;
	private String journeydate;
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestianation() {
		return destianation;
	}
	public void setDestianation(String destianation) {
		this.destianation = destianation;
	}
	public int getPassengers() {
		return passengers;
	}
	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}
	public Planjourney(String source, String destianation, int passengers, String journeydate) {
		super();
		this.source = source;
		this.destianation = destianation;
		this.passengers = passengers;
		this.journeydate = journeydate;
	}
	Planjourney(){
		
	}

	public static Planjourney getPlanjourney() {
		return new Planjourney();
	}
	public String getJourneydate() {
		return journeydate;
	}
	public void setJourneydate(String journeydate) {
		this.journeydate = journeydate;
	}
}
