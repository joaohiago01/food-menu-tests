package authentication;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import bean.ClientBean;
import entity.Client;

public class SignInTest {

	ClientBean clientService = mock(ClientBean.class);
	
	Client client = mock(Client.class);
	
	@Test
	void userHasLogin() throws SQLException {
			when(clientService.signIn("hiago@gmail.com", "123")).thenReturn(client);
			assertTrue("Esse Usuário Não Existe", 
					clientService.signIn("hiago@gmail.com", "123") != null);	
	}
}
