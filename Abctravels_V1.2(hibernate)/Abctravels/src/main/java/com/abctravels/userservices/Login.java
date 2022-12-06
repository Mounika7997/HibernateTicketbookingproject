package com.abctravels.userservices;
import java.util.Scanner;

public class Login {
	static Scanner sc;
	public static void login()  {
		sc  = new Scanner(System.in);
		System.out.println("Enter User name :");
		String username = sc.next();
		username.trim();
		System.out.println("Enter password :");

		String password = sc.next();
		password.trim();

		UserLoginimpl ul = new UserLoginimpl();

		try {
			ul.logincheck(username, password);
		} catch (Exception e) {
			e.getMessage();
		}
	}
}