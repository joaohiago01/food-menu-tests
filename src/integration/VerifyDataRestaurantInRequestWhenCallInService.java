package integration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Test;

import bean.RestaurantBean;
import entity.Restaurant;

public class VerifyDataRestaurantInRequestWhenCallInService {

	HttpServletRequest request = mock(HttpServletRequest.class);
	
	RestaurantBean restaurantService = mock(RestaurantBean.class);
	
	Restaurant restaurant = mock(Restaurant.class);
	
	@Test
	public void verifyClientIdInRequestParamWhenCallReadClientById() throws SQLException {
		when(request.getParameter("restaurantID")).thenReturn("1");
		
		assertFalse("Restaurante Não Cadastrado", 
				restaurantService.readById(Integer.parseInt(request.getParameter("restaurantID"))) != null);
	}
	
	@Test
	public void verifyClientDataInRequestParamsWhenCallCreateClient() {
		when(request.getParameter("name")).thenReturn("Pizzaria");
		when(request.getParameter("cnpj")).thenReturn("123.456.789-10/0001-00");
		when(request.getParameter("state")).thenReturn("PB");
		when(request.getParameter("city")).thenReturn("Monteiro");
		when(request.getParameter("cep")).thenReturn("58500-500");
		when(request.getParameter("district")).thenReturn("Centro");
		when(request.getParameter("number")).thenReturn("123");
		when(request.getParameter("phone")).thenReturn("999999999");
		when(request.getParameter("time_open")).thenReturn("07:00");
		when(request.getParameter("time_close")).thenReturn("20:00");
		when(request.getParameter("sunday")).thenReturn("off");
		when(request.getParameter("monday")).thenReturn("off");
		when(request.getParameter("tuesday")).thenReturn("off");
		when(request.getParameter("thursday")).thenReturn("off");
		when(request.getParameter("wednesday")).thenReturn("off");
		when(request.getParameter("friday")).thenReturn("off");
		when(request.getParameter("saturday")).thenReturn("on");
		when(request.getParameter("delivery")).thenReturn("offYes");
		
		restaurant.setCnpj(request.getParameter("cnpj"));
		restaurant.setName(request.getParameter("name"));
		restaurant.setDescription(request.getParameter("description"));
		restaurant.setState(request.getParameter("state"));
		restaurant.setCity(request.getParameter("city"));
		restaurant.setCep(request.getParameter("cep"));
		restaurant.setDistrict(request.getParameter("district"));
		restaurant.setAddress(request.getParameter("address"));
		restaurant.setNumber(request.getParameter("number"));
		restaurant.setAddition(request.getParameter("addition"));
		restaurant.setPhone(request.getParameter("phone"));
		restaurant.setTime_open(request.getParameter("time_open"));
		restaurant.setTime_close(request.getParameter("time_close"));
		boolean delivery;
		if (request.getParameter("delivery") != null && (request.getParameter("delivery").equalsIgnoreCase("offYes") || request.getParameter("delivery").equalsIgnoreCase("onNo"))) {
			delivery = false;
		} else {
			delivery = true;
		}
		restaurant.setDelivery(delivery);
		boolean sunday = true, monday = true, tuesday = true, wednesday = true, thursday = true, friday = true, saturday = true;

		if (request.getParameter("sunday") == null || request.getParameter("sunday").equals("off")) {
			sunday = false;
		} if (request.getParameter("monday") == null || request.getParameter("monday").equals("off")) {
			monday = false;
		} if (request.getParameter("tuesday") == null || request.getParameter("tuesday").equals("off")) {
			tuesday = false;
		} if (request.getParameter("thursday") == null || request.getParameter("thursday").equals("off")) {
			thursday = false;
		} if (request.getParameter("wednesday") == null || request.getParameter("wednesday").equals("off")) {
			wednesday = false;
		} if (request.getParameter("friday") == null || request.getParameter("friday").equals("off")) {
			friday = false;
		} if (request.getParameter("saturday") == null || request.getParameter("saturday").equals("off")) {
			saturday = false;
		}
		restaurant.setSunday_open(sunday);
		restaurant.setMonday_open(monday);
		restaurant.setTuesday_open(tuesday);
		restaurant.setThursday_open(thursday);
		restaurant.setWednesday_open(wednesday);
		restaurant.setFriday_open(friday);
		restaurant.setSaturday_open(saturday);
		
		assertThrows(SQLException.class, () -> restaurantService.create(restaurant));
	}
	
	@Test
	public void verifyClientDataInRequestParamsWhenCallUpdateClient() {
		when(request.getParameter("name")).thenReturn("Pizzaria");
		when(request.getParameter("cnpj")).thenReturn("123.456.789-10/0001-00");
		when(request.getParameter("state")).thenReturn("PB");
		when(request.getParameter("city")).thenReturn("Monteiro");
		when(request.getParameter("cep")).thenReturn("58500-500");
		when(request.getParameter("district")).thenReturn("Centro");
		when(request.getParameter("number")).thenReturn("123");
		when(request.getParameter("phone")).thenReturn("999999999");
		when(request.getParameter("time_open")).thenReturn("07:00");
		when(request.getParameter("time_close")).thenReturn("20:00");
		when(request.getParameter("sunday")).thenReturn("off");
		when(request.getParameter("monday")).thenReturn("off");
		when(request.getParameter("tuesday")).thenReturn("off");
		when(request.getParameter("thursday")).thenReturn("off");
		when(request.getParameter("wednesday")).thenReturn("off");
		when(request.getParameter("friday")).thenReturn("off");
		when(request.getParameter("saturday")).thenReturn("on");
		when(request.getParameter("delivery")).thenReturn("offYes");
		
		restaurant.setCnpj(request.getParameter("cnpj"));
		restaurant.setName(request.getParameter("name"));
		restaurant.setDescription(request.getParameter("description"));
		restaurant.setState(request.getParameter("state"));
		restaurant.setCity(request.getParameter("city"));
		restaurant.setCep(request.getParameter("cep"));
		restaurant.setDistrict(request.getParameter("district"));
		restaurant.setAddress(request.getParameter("address"));
		restaurant.setNumber(request.getParameter("number"));
		restaurant.setAddition(request.getParameter("addition"));
		restaurant.setPhone(request.getParameter("phone"));
		restaurant.setTime_open(request.getParameter("time_open"));
		restaurant.setTime_close(request.getParameter("time_close"));
		boolean delivery;
		if (request.getParameter("delivery") != null && (request.getParameter("delivery").equalsIgnoreCase("offYes") || request.getParameter("delivery").equalsIgnoreCase("onNo"))) {
			delivery = false;
		} else {
			delivery = true;
		}
		restaurant.setDelivery(delivery);
		boolean sunday = true, monday = true, tuesday = true, wednesday = true, thursday = true, friday = true, saturday = true;

		if (request.getParameter("sunday") == null || request.getParameter("sunday").equals("off")) {
			sunday = false;
		} if (request.getParameter("monday") == null || request.getParameter("monday").equals("off")) {
			monday = false;
		} if (request.getParameter("tuesday") == null || request.getParameter("tuesday").equals("off")) {
			tuesday = false;
		} if (request.getParameter("thursday") == null || request.getParameter("thursday").equals("off")) {
			thursday = false;
		} if (request.getParameter("wednesday") == null || request.getParameter("wednesday").equals("off")) {
			wednesday = false;
		} if (request.getParameter("friday") == null || request.getParameter("friday").equals("off")) {
			friday = false;
		} if (request.getParameter("saturday") == null || request.getParameter("saturday").equals("off")) {
			saturday = false;
		}
		restaurant.setSunday_open(sunday);
		restaurant.setMonday_open(monday);
		restaurant.setTuesday_open(tuesday);
		restaurant.setThursday_open(thursday);
		restaurant.setWednesday_open(wednesday);
		restaurant.setFriday_open(friday);
		restaurant.setSaturday_open(saturday);
		
		assertThrows(SQLException.class, () -> restaurantService.update(restaurant));
	}
}
