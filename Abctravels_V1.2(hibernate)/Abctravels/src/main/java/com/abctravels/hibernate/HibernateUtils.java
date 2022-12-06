package com.abctravels.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.abctravels.userservices.User;

public class HibernateUtils {

	private static SessionFactory sf;

	public static SessionFactory getSessionFactory() {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		config.addAnnotatedClass(User.class);

		sf = config.buildSessionFactory();

		return sf;

	}

	private HibernateUtils() {
	}



}
