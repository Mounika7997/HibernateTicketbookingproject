package com.abctravels.planjourney;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.abctravels.userservices.User;
import com.abctravels.userservices.UserLoginimpl;

public class Planjourneyimpl implements Planjourneyservice {
	 User user; 
	Planjourney journey = Planjourney.getPlanjourney();
	

	@SuppressWarnings("deprecation")
	public int journeydate() {
		System.out.println("Enter date of journey in DD/MM/YYY:");
		
		journey.setJourneydate(UserLoginimpl.sc.next());

		SimpleDateFormat dateformatter = new SimpleDateFormat("dd/MM/yyyy");

		Date tempDate = null;
		try {

			tempDate = dateformatter.parse(journey.getJourneydate());

		} catch (ParseException e) {

			e.getMessage();
			journeydate();
		}

		return tempDate.getDay();

	}

	public void journeyroute() {
		System.out.println("Enter from location");

		journey.setSource(UserLoginimpl.sc.next());

		System.out.println("Enter destiantion location");

		journey.setDestianation(UserLoginimpl.sc.next());

		System.out.println("Enter number of passengers:");
		journey.setPassengers(UserLoginimpl.sc.nextInt());

	}

	public void bill(User user) {
		Random rm = new Random();
		this.user=user;

		int price = rm.nextInt(5000);

		int totalprice = price * journey.getPassengers();
		System.out.println("Your user id" + user.getEmailId());
		System.out.println("Your name " + user.getFirstName() + user.getLastName());
		System.out.println("your date of journey" + journey.getJourneydate());

		System.out.println("Price from  " + journey.getSource() + " to " + journey.getDestianation() + ":" + "for "
				+ journey.getPassengers() + " passengers is:" + totalprice + "/- rupees only ");

	}

	public static Planjourneyimpl getPlanjourneyobj() {
		return new Planjourneyimpl();
	}

	

}