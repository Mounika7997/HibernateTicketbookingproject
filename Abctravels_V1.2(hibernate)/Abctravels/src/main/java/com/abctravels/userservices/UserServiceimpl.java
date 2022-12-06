package com.abctravels.userservices;


import java.util.Map;


import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.abctravels.planjourney.Planjourneyimpl;
import com.abctravels.planjourney.Planjourneyservice;

public class UserServiceimpl {

	static SessionFactory sf;
	static Session session;
	static Map<String, User> userdetails;
	 static User user ;

	static Scanner sc = new Scanner(System.in);

	public  static void services() 
	{
		System.out.println("Are you want to Login or SignUp ?");
		String action = sc.next();
		if (action.equalsIgnoreCase("Login"))
			user = UserLoginimpl.login();
		else if (action.equalsIgnoreCase("SignUp")) 
		{
			user = Signupimpl.signup();
		} else 
		{
			System.out.println("Invalid action");
		}
		Planjourneyservice pjs = Planjourneyimpl.getPlanjourneyobj();
		pjs.journeyroute();
		pjs.journeydate();
		pjs.bill(user);

	}

	
}