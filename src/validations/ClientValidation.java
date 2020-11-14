package validations;

import entity.Client;

public class ClientValidation {

	public boolean validateNameClient(Client newClient, String nameClient) {
		if (nameClient.length() >= 3 && nameClient.length() <= 40) {
			newClient.setName(nameClient);
			return true;
		}
		return false;
	}
}
