package integration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Test;

import bean.ProductBean;
import entity.Product;

public class VerifyDataProductInRequestWhenCallInService {

	HttpServletRequest request = mock(HttpServletRequest.class);
	
	ProductBean productService = mock(ProductBean.class);
	
	Product product = mock(Product.class);
	
	@Test
	public void verifyClientIdInRequestParamWhenCallReadClientById() throws SQLException {
		when(request.getParameter("productID")).thenReturn("1");
		
		assertFalse("Produto Não Cadastrado", 
				productService.readById(Integer.parseInt(request.getParameter("productID"))) != null);
	}
	
	@Test
	public void verifyClientDataInRequestParamsWhenCallCreateClient() {
		when(request.getParameter("name")).thenReturn("Pizza Calabresa");
		when(request.getParameter("description")).thenReturn("12 Fatias");
		when(request.getParameter("price")).thenReturn("20.00");
		
		product.setName(request.getParameter("name"));
		product.setDescription(request.getParameter("description"));
		product.setPrice(request.getParameter("price"));
		
		assertThrows(SQLException.class, () -> productService.create(product));
	}
	
	@Test
	public void verifyClientDataInRequestParamsWhenCallUpdateClient() {
		when(request.getParameter("name")).thenReturn("Pizza Calabresa");
		when(request.getParameter("description")).thenReturn("12 Fatias");
		when(request.getParameter("price")).thenReturn("20.00");
		
		product.setName(request.getParameter("name"));
		product.setDescription(request.getParameter("description"));
		product.setPrice(request.getParameter("price"));
		
		assertThrows(SQLException.class, () -> productService.update(product));
	}
}
