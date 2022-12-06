package com.abctravels.planjourney;

import com.abctravels.userservices.User;

public interface Planjourneyservice {
	public abstract void journeyroute();

	public abstract int journeydate();

	public abstract void bill(User user);

	

}
