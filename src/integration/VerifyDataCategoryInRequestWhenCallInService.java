package integration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Test;

import bean.CategoryProductBean;
import entity.Category;

public class VerifyDataCategoryInRequestWhenCallInService {

	HttpServletRequest request = mock(HttpServletRequest.class);
	
	CategoryProductBean categoryService = mock(CategoryProductBean.class);
	
	Category categoryProduct = mock(Category.class);
	
	@Test
	public void verifyClientIdInRequestParamWhenCallReadClientById() throws SQLException {
		when(request.getParameter("categoryID")).thenReturn("1");
		
		assertFalse("Categoria Não Cadastrada", 
				categoryService.readById(Integer.parseInt(request.getParameter("categoryID"))) != null);
	}
	
	@Test
	public void verifyClientDataInRequestParamsWhenCallCreateClient() {
		when(request.getParameter("name")).thenReturn("Pizzas");
		
		categoryProduct.setName(request.getParameter("name"));
		
		assertThrows(SQLException.class, () -> categoryService.create(categoryProduct));
	}
	
	@Test
	public void verifyClientDataInRequestParamsWhenCallUpdateClient() {
		when(request.getParameter("name")).thenReturn("Pizzas");
		
		categoryProduct.setName(request.getParameter("name"));
		
		assertThrows(SQLException.class, () -> categoryService.update(categoryProduct));
	}
}
