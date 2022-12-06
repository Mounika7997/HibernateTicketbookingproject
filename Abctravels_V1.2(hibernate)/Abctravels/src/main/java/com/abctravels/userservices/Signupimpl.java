package com.abctravels.userservices;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.abctravels.exceptions.UserMailExisted;
import com.abctravels.hibernate.HibernateUtils;

public class Signupimpl {
	static Map<String, User> data;
	static Scanner sc;
	static SessionFactory sf;
	static Session session;
	
	

	public static User signup() {
		sf = HibernateUtils.getSessionFactory();
		session = sf.openSession();
		session.beginTransaction();
		User user = User.getUser();
		sc = new Scanner(System.in);
		System.out.println("Enter email Id");
		user.setEmailId(sc.next());
		
		boolean exists = session.load(User.class, user.getEmailId())== null? false:true;

		if (exists) {
			System.out.println("Enter your firstname:");
			user.setFirstName(sc.next());
			System.out.println("Enter your last name");
			user.setLastName(sc.next());
			System.out.println("Enter your gender");
			user.setGender(sc.next().charAt(0));
			System.out.println("Enter your phone number : ");
			user.setMobileNumber(sc.nextLong());

			System.out.println("Enter your password : ");
			user.setPassword(sc.next());
			data = new HashMap<String, User>();
			data.put(user.getEmailId(), user);
			session.save(user);
			session.getTransaction().commit();
			System.out.println("User saved successfulyy");
			
			return user;
		} else {
			System.out.println("Email already exists ...Try another");
			throw new UserMailExisted("Email already exists ...Try another");
		}

	}

}
