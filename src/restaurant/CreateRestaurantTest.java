package restaurant;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import entity.Client;
import entity.Restaurant;
import validations.RestaurantValidation;

public class CreateRestaurantTest {
	
	@Rule
    public MockitoRule initRule = MockitoJUnit.rule();
    
	Restaurant newRestaurant = spy(Restaurant.class);
	
	Client client = spy(Client.class);
	
	RestaurantValidation restaurantValidation = spy(RestaurantValidation.class);
		
	@Test
	void createRestaurantWithoutClientAssociated() {
		restaurantValidation.validateClientAssociated(newRestaurant, client);
		assertTrue("Restaurante Deve Possuir Uma Pessoa Associada",
				newRestaurant.getClient() != null);
	}
	
	@Test
	void createRestaurantWithNameMinimumOf3Characters() {
		restaurantValidation.validateNameRestaurant(newRestaurant, "Sol");
		verify(newRestaurant).setName("Sol");
		assertTrue("Restaurante Deve Ter Um Nome Com No Minímo 3 Caracteres", 
				newRestaurant.getName().length() >= 3);
	}
	
	@Test
	void createRestaurantWithNameMaximumOf40Characters() {
		restaurantValidation.validateNameRestaurant(newRestaurant, "Restaurante Monteiro");
		verify(newRestaurant).setName("Restaurante Monteiro");
		assertTrue("Restaurante Deve Ter Um Nome Com No Maxímo 40 Caracteres",
				newRestaurant.getName().length() <= 40);
	}
	
	@Test
	void createRestaurantThatDoesNotOpenAnyDayOfTheWeek() {
		when(newRestaurant.isMonday_open()).thenReturn(false);
		assertFalse("Restaurante Deve Abrir Pelo Menos Um Dia Na Semana", 
				restaurantValidation.validateRestaurantOpenAnyDayOfTheWeek(newRestaurant) == true
				);
	}
}
