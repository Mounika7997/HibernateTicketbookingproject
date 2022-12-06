package com.abctravels.userservices;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.abctravels.exceptions.InvalidCredentialsExceptions;
import com.abctravels.hibernate.HibernateUtils;

public class UserLoginimpl {
	public static Scanner sc = new Scanner(System.in);
	 static SessionFactory sf;
	 static Session session;
	 static Map<String, User> userdetails ;

	public static  User login() throws HibernateException {
		sf = HibernateUtils.getSessionFactory();
		session = sf.openSession();
		session.beginTransaction();

		System.out.println("Enter User name :");
		String username = sc.next();
		username.trim();
		System.out.println("Enter password :");

		String password = sc.next();
		password.trim();
		User us = User.getUser();
		us.setEmailId(username);

		if (isExistInDB(us)) {
			userdetails = new HashMap<String, User>();
			us = (User) session.get(User.class, us.getEmailId());

			userdetails.put(us.getEmailId(), us);
			if (userdetails.get(username).getFailedCount() < 5) {
				if (userdetails.get(username).getPassword().equals(password)) {
					System.out.println("User loggined successfully");
					return us;
				} else {
					userdetails.get(username).setFailedCount(userdetails.get(username).getFailedCount() + 1);
					userdetails.put(us.getEmailId(), us);
					System.out.println("Invalid passowrd");

					us.setFailedCount(us.getFailedCount() + 1);
					session.update(us);
					session.getTransaction().commit();
					throw new InvalidCredentialsExceptions("Invalid password ");

				}
			}

			else {
				System.out.println("Account excedeed maximum no.of sigin attempsts and account locked");
				userdetails.get(username).setAccountStatus(false);
				session.update(us);
				session.getTransaction().commit();
				throw new InvalidCredentialsExceptions(
						"Account excedeed maximum no.of sigin attempsts and account locked");

			}
		} else {
			System.out.println("No Register user with this email, try Sigup");
			throw new InvalidCredentialsExceptions("No User exist in DB");
		}

	}

	public UserLoginimpl() {
	
	}

	public static  boolean isExistInDB(User user)

	{
		sf = HibernateUtils.getSessionFactory();
		session = sf.openSession();
		session.beginTransaction();
		user = (User) session.get(User.class, user.getEmailId());

		return user != null ? true : false; }
		
         public void logincheck(String username, String password) {
        	 
			
			
		}
		

	}


