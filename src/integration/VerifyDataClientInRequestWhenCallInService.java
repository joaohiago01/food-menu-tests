package integration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Test;

import bean.ClientBean;
import entity.Client;

public class VerifyDataClientInRequestWhenCallInService {

	HttpServletRequest request = mock(HttpServletRequest.class);
	
	ClientBean clientService = mock(ClientBean.class);
	
	Client client = mock(Client.class);
	
	@Test
	public void verifyClientIdInRequestParamWhenCallReadClientById() throws SQLException {
		when(request.getParameter("clientID")).thenReturn("1");
		
		assertFalse("Usuário Não Existe", 
				clientService.readById(Integer.parseInt(request.getParameter("clientID"))) != null);
	}
	
	@Test
	public void verifyClientDataInRequestParamsWhenCallCreateClient() {
		when(request.getParameter("name")).thenReturn("João");
		when(request.getParameter("cpf")).thenReturn("123.456.789-10");
		when(request.getParameter("email")).thenReturn("joao@gmail.com");
		when(request.getParameter("password")).thenReturn("123456");
		
		client.setCpf(request.getParameter("cpf"));
		client.setName(request.getParameter("name"));
		client.setEmail(request.getParameter("email"));
		client.setPassword(request.getParameter("password"));
		
		assertThrows(SQLException.class, () -> clientService.create(client));
	}
	
	@Test
	public void verifyClientDataInRequestParamsWhenCallUpdateClient() {
		when(request.getParameter("name")).thenReturn("João");
		when(request.getParameter("cpf")).thenReturn("123.456.789-10");
		when(request.getParameter("email")).thenReturn("joao@gmail.com");
		when(request.getParameter("password")).thenReturn("123456");
		
		client.setCpf(request.getParameter("cpf"));
		client.setName(request.getParameter("name"));
		client.setEmail(request.getParameter("email"));
		client.setPassword(request.getParameter("password"));
		
		assertThrows(SQLException.class, () -> clientService.update(client));
	}
}
