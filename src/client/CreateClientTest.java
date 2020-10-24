package client;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.spy;

import org.junit.jupiter.api.Test;

import entity.Client;
import validations.ClientValidation;

public class CreateClientTest {

	Client newClient = spy(Client.class);
	
	ClientValidation clientValidation = spy(ClientValidation.class);
	
	@Test
	void createClientWithNameMinimumOf3Characters() {
		assertFalse("Cliente Deve Ter Um Nome Com No Min�mo 3 Caracteres",
				clientValidation.validateNameClient(newClient, "An") == true);
	}
	
	@Test
	void createClientWithNameMaximumOf40Characters() {
		assertFalse("Cliente Deve Ter Um Nome Com No Max�mo 40 Caracteres",
				clientValidation
				.validateNameClient(newClient, "Jo�o Anderson Henrique Justino Da Silva Moreira De Melo Sousa") == true);
	}
}
