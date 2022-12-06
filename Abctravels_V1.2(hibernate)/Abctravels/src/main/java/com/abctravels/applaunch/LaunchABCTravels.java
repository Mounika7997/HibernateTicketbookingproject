package com.abctravels.applaunch;

import java.io.IOException;
import java.sql.SQLException;

import com.abctravels.planjourney.Planjourneyimpl;
import com.abctravels.userservices.User;
import com.abctravels.userservices.UserServiceimpl;

public class LaunchABCTravels {

	public static void main(String[] args) throws IOException, SQLException {

		Logo.logoLaunch();
		
		UserServiceimpl.services();

	}
}
