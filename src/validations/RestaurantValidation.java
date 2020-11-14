package validations;

import entity.Client;
import entity.Restaurant;

public class RestaurantValidation {

	public boolean validateClientAssociated(Restaurant newRestaurant, Client client) {
		if (client != null) {
			newRestaurant.setClient(client);
			return true;
		}
		return false;
	}

	public boolean validateNameRestaurant(Restaurant newRestaurant, String nameRestaurant) {
		if (nameRestaurant.length() >= 3 && nameRestaurant.length() <= 40) {
			newRestaurant.setName(nameRestaurant);
			return true;
		}
		return false;
	}

	public boolean validateRestaurantOpenAnyDayOfTheWeek(Restaurant newRestaurant) {
		if (newRestaurant.isMonday_open() == true || newRestaurant.isTuesday_open() == true ||
				newRestaurant.isWednesday_open() == true || newRestaurant.isThursday_open() == true ||
				newRestaurant.isFriday_open() == true || newRestaurant.isSaturday_open() == true ||
				newRestaurant.isSunday_open() == true) {
			return true;
		}
		return false;
	}
}
